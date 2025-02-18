from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.

def index(request):
  return HttpResponse("<h1>Welcome Page</h1>")

def detail(request, post_id):
  print(type(post_id))
  return HttpResponse("post_id " + str(post_id))
