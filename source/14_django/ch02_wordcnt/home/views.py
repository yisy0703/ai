from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.
def index(request):
  context = {'msg': 'WordCount Welcome Page',
             'greeting':'Hello, Django(장고)'}
  return render(request=request,
                template_name='home/index.html',
                context=context)
