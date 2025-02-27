from django.shortcuts import render
from django.views.generic import ListView

from article.models import Article

# Create your views here.
article_list =ListView.as_view(model=Article)
