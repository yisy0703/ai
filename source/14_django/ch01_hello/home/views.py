from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.
def home(request):
  # return HttpResponse("<h1>Hello</h1>")
  msg = 'Django(장고)'
  return render(request,
                'home.html',
                {'m':msg})
