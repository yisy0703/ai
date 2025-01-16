# pip install jinja2
from fastapi import FastAPI
from fastapi.staticfiles import StaticFiles # static 폴더 지정
from fastapi.templating import Jinja2Templates # 템플릿 지정
from fastapi import Request # html로 rendering 하기 위함
from pydantic import BaseModel # form 데이터 자동 검증
from fastapi import Form # post방식으로 들어온 form 데이터 받을 때

app = FastAPI()
templates = Jinja2Templates(directory="templates")
app.mount("/static", StaticFiles(directory="static"), name="static")

@app.get('/')
@app.get('/html1')
async def html1(request:Request):
  return templates.TemplateResponse("ex3-1.html", {'request':request})












