from django.contrib import admin
from student.models import Student

# Register your models here.
admin.site.register(Student) # admin페이지에서 Student 테이블 확인 용도
