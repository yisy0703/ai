from django.db import models
import time
from datetime import datetime
from django.urls import reverse
STATUS_CHOICES = (
  ('d', 'Draft'),
  ('p', 'Published'),
  ('w', 'Withdrawn'),
)
def article_photo_path(instance, filename):
  now = datetime.now()
  timestamp = int(time.time() * 1000)  # 밀리초 단위 타임스탬프 생성
  return f"article/{now.strftime('%Y%m%d')}/{timestamp}_{filename}"
class Article(models.Model):
  title = models.CharField(verbose_name='기사제목', max_length=100)
  body  = models.TextField(verbose_name='기사본문')
  status = models.CharField(max_length=1, choices=STATUS_CHOICES)
  #photo = models.ImageField(blank=True, upload_to='article/%Y/%m/%d')
  # pip install pillow
  photo = models.ImageField(blank=True, upload_to=article_photo_path)

  def __str__(self):
    return self.title

  def get_absolute_url(self):
    # return reverse('article:list')
    return  reverse('article:detail', args=[self.id])









