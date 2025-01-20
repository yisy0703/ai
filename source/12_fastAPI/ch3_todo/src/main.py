# src -> 소스 루트
# pip install fastapi
# pip install uvicorn
# pip install jinja2
# pip install python-multipart (post사용)

from fastapi import FastAPI
from fastapi import Request # template으로 갈 핸들러 함수 매개변수
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from starlette.responses import RedirectResponse #redirect
# from pydantic import BaseModel # 자동 타입 체크
from models import ToDoRequest













