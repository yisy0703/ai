from django.shortcuts import render
from student.models import Student

# Create your views here.
def index(request):
  students = Student.objects.all()
  return render(request,
                'student/list.html',
                {'students':students})