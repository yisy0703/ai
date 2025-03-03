from django.urls import path
from . import views
urlpatterns = [
  path('signup/', views.signup, name='signup'), # 회원가입
  path('login/', views.login, name='login'), #로그인
  path('profile/', views.profile, name='profile'), # 회원정보
  path('logout/', views.logout, name='logout'), #로그아웃
]