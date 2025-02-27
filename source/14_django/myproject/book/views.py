from django.db.transaction import commit
from django.shortcuts import render, redirect, reverse, get_object_or_404
from django.urls import reverse_lazy
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
class BookCreateView(CreateView):
  model = Book
  fields = ['title', 'author', 'publisher', 'sales']
  # template_name = 'book/book_formxxxxxx.html'
  # success_url = 'book:list' 미지정시 get_absolute_url()메소드 수행
  def form_valid(self, form): # 유효성 검사 성공 후 자동 호출
    book = form.save(commit=False)
    book.ip = self.request.META['REMOTE_ADDR']
    book.save()
    return redirect(book)
book_new = BookCreateView.as_view()
# book_new = CreateView.as_view(model=Book,
#                 fields=['title','author','publisher','sales'],
#                 template_name='',
#                 success_url='book:list') # pt.22

# def book_new(request):
#   if request.method == 'POST':
#     # request.POST의 파라미터 값을 book으로 save()
#     form = BookModelForm(request.POST)
#     if form.is_valid():
#       # book = Book(**form.cleaned_data)
#       book = form.save(commit=False)
#       book.ip = request.META['REMOTE_ADDR'] # 요청한 client의 ip
#       book.save()
#       return redirect(book) # book.get_absolute_url 자동 호출
#       # return redirect('book:list')
#   else:
#     #form = BookForm()
#     form = BookModelForm()
#   return render(request,
#                   'book/book_form.html',
#                   {'form':form })
book_edit = UpdateView.as_view(model=Book,
                 fields=['title', 'author', 'publisher', 'sales'])
# def book_edit(request, pk):
#   book = get_object_or_404(Book, pk=pk)
#   print('수정될 책 정보 ', book)
#   if request.method == 'POST':
#     # 파라미터정보를 form객체로 받아 유효성 체크 (1)성공시 save (2)실패시 form태그페이지
#     form = BookModelForm(request.POST, instance=book)
#     if form.is_valid():
#       book = form.save(commit=False)
#       # book.ip = request.META['REMOTE_ADDR']
#       book.save()
#       return redirect(book)
#   else:
#     form = BookModelForm(instance=book)
#   return render(request,
#                   'book/book_form.html',
#                   {'form':form})
book_delete = DeleteView.as_view(model=Book,
                     # success_url="/book"
                     success_url = reverse_lazy("book:list")
                    )
# def book_delete(request, pk):
#   book = get_object_or_404(Book, pk=pk)
#   if request.method == 'POST':
#     book.delete()
#     return redirect(book)
#   else:
#     return render(request,
#            'book/book_confirm_delete.html',
#            {'object':book})











