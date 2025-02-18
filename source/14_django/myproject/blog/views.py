from django.http import HttpResponse
from django.shortcuts import render
from .models import Post

def index(request):
  post_list = Post.objects.all()
  output = '<br>'.join([post.__str__() for post in post_list])
  print(output)
  return HttpResponse("<h1>Welcome Page</h1>" + output)

def detail(request, post_id):
  post = Post.objects.get(pk=post_id)
  return HttpResponse(post.__str__())
