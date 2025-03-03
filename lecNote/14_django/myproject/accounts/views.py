from django.contrib.auth.views import LoginView, LogoutView
from django.shortcuts import render, redirect
#from django.contrib.auth.forms import UserCreationForm
#from django.conf import settings
from django.conf import global_settings as settings
from .forms import SignupForm
from .models import Profile

def signup(request):
  print('★★★★★ :', request.method, '\n', request.POST)
  if request.method == 'POST':
    form = SignupForm(request.POST)
    if form.is_valid():
      form.save()
      return redirect(settings.LOGIN_URL)
  else:
    form = SignupForm()
  return render(request,
                'accounts/signup_form.html',
                {'form':form})
login = LoginView.as_view(template_name='accounts/login_form.html')

logout = LogoutView.as_view(next_page=settings.LOGIN_URL)

def profile(request):
  if request.user.__str__() != 'AnonymousUser':
    profile = Profile.objects.get(user=request.user)
  else:
    print(request.user)
    profile = None
  return render(request,
                'accounts/profile.html',
                {'profile':profile})
