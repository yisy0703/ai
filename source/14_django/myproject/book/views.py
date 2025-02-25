from django.shortcuts import render, redirect

from .forms import BookForm, BookModelForm
from .models import Book
from django.views.generic import ListView
from django.views.generic import CreateView
from django.views.generic import UpdateView
from django.views.generic import DeleteView

book_list = ListView.as_view(model=Book)
# def book_list(request):
#   return render(request,
#                 'book/book_list.html',
#                 {'book_list':Book.objects.all()})

def book_new(request):
  if request.method == 'POST':
    # request.POST의 파라미터 값을 book으로 save()
    return redirect('book:list')
  else:
    #form = BookForm()
    form = BookModelForm()
    return render(request, 'book/book_form.html',
                  {'form':form })

def book_edit(request):
  pass

def book_delete(request):
  pass
