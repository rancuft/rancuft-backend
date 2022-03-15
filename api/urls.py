from django.urls import path, include
from .views import hellowApi

urlpatterns = [
    path("hello/", hellowApi),

]
