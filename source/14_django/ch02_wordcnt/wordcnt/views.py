from django.shortcuts import render

def wordinput(request):
  return render(request,
    'wordcnt/wordinput.html')
