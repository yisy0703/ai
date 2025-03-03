"""
URL configuration for myproject project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/5.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include
from django.shortcuts import redirect
urlpatterns = [
    path("admin/", admin.site.urls),
    path("", lambda r : redirect("article:list")),
    path("blog/", include("blog.urls")),
    path("book/", include("book.urls")),
    path("article/", include("article.urls")),
    # path("file/", include("filetest.urls")),
    path("accounts/", include("accounts.urls")),
]
# 사용자가 업로그한 파일(MEDIA_ROOT)을 url(MEDIA_URL)과 연결
# 장고는 static은 자동 연결해 주나, media는 개발자가 연결
from django.conf.urls.static import static
from . import settings
urlpatterns += static(settings.MEDIA_URL,
                      document_root=settings.MEDIA_ROOT)









