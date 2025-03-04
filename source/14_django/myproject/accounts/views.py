from django.shortcuts import render
from django.contrib.auth.views import LoginView, LogoutView
from django.conf import global_settings as settings

def signup(request):
  pass

login = LoginView.as_view(template_name='accounts/login_form.html')

def profile(request):
  pass

logout = LogoutView.as_view(next_page=settings.LOGIN_URL)