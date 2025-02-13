from django.http import HttpResponse
from django.shortcuts import render

def wordinput(request):
  return render(request,
    'wordcnt/wordinput.html')

def about(request):
  return render(request,
                "wordcnt/about.html")

def result(request):
  # post방식으로 전달된 fulltxt 파라미터 받아 글자수, 단어수, 단어당출현빈도 계산
  # print(request.POST['fulltxt'], request.POST.get('fulltxt', ''))
  fulltxt = request.POST['fulltxt'] #홍 홍 화이팅
  strlength = len(fulltxt) # 글자수
  words = fulltxt.split() # space단위로 단어 분리 ['홍','홍','화이팅']
  wordcnt = len(words)    # 단어 갯수
  return HttpResponse('TEST')
















