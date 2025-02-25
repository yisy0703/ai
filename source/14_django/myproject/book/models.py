from django.db import models
from django import forms
from django.core.validators import MinLengthValidator
from django.core.validators import MinValueValidator
from django.core.validators import MaxValueValidator

def min_length_3_validator(value):
  if len(value)<3:
    raise forms.ValidationError('3글자 이상 입력하세요')
# Create your models here.
class Book(models.Model):
  title  = models.CharField(max_length=50)
  author = models.CharField(max_length=50,
                            validators=[#min_length_3_validator
                                        MinLengthValidator(3) ])
  publisher = models.CharField(max_length=50, blank=True, null=True)
  publication_date = models.DateTimeField(auto_now_add=True)
  sales     = models.IntegerField(default=1000,
                                  validators=[MinValueValidator(0),
                                              MaxValueValidator(1000000)])
  ip        = models.GenericIPAddressField(blank=True, null=True)

  def __str__(self):
    return "{}:{}著 {:,}원 from{}".format(self.title,
                                         self.author,
                                         self.sales,
                                         self.ip)
  class Meta:
    ordering = ['-publication_date']
    unique_together = (('title','author'), )
