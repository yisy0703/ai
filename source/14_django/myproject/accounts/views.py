from django.shortcuts import render, redirect
from django.contrib.auth.views import LoginView, LogoutView
from django.conf import global_settings as settings
from .forms import SignupForm

def signup(request):
  if request.method == 'POST':
    # 회원정보 save()
    form = SignupForm(request.POST)
    if form.is_valid():
      form.save()
      # 회원가입 후 갈 페이지로 redirect(""/account/login")
      return redirect(settings.LOGIN_URL)
  else:
    form = SignupForm()
  return render(request,
                'accounts/signup_form.html',
                {'form':form})

login = LoginView.as_view(template_name='accounts/login_form.html')

def profile(request):
  pass

logout = LogoutView.as_view(next_page=settings.LOGIN_URL)