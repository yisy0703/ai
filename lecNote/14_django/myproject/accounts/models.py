from django.db import models
from django.contrib.auth.models import User

class Profile(models.Model):
  user = models.OneToOneField(User, on_delete=models.CASCADE)
  phone_number = models.CharField(verbose_name="전화", max_length=20)
  address      = models.CharField(verbose_name="주소", max_length=50)
  def __str__(self):
    return "{}({}-{})".format(self.user.username,
                              self.phone_number,
                              self.address)
# 이벤트 처리 : 회원가입 완료 후 가입인사 이메일 전송
from django.db.models.signals import post_save
from django.conf.global_settings import AUTH_USER_MODEL
from django.core.mail import send_mail
def on_send_mail(sender, **kwargs):
  if kwargs['created']:
    user = kwargs['instance']
    title = user.username+'님 가입을 환영합니다'
    body_no_tag = 'html태그 없이 {}님 가입을 환영합니다'.format(user.username)
    body_with_tag = '<h1>{}님 가입을 환영합니다(HTML 태그 포함)</h1><h2>진심진심</h2>'.format(user.username)
    # 이 함수쓰기 전 setting.py에 셋팅
    send_mail(subject=title,
              message=body_no_tag,
              from_email='yisy0703@naver.com',
              recipient_list=[user.email],
              fail_silently=False,
              html_message= body_with_tag
              )
post_save.connect(on_send_mail, sender=AUTH_USER_MODEL)