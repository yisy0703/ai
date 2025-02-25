from django.shortcuts import render
from .models import Book

def book_list(request):
  return render(request,
                'book/book_list.html',
                {'book_list':Book.objects.all()})

def book_new(request):
  pass

def book_edit(request):
  pass

def book_delete(request):
  pass
