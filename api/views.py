from rest_framework import  viewsets
from rest_framework.decorators import api_view
from rest_framework.response import Response
from api.models import User


class UserViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all()


@api_view(['GET'])
def hellowApi(request):
    return Response("Hello API")