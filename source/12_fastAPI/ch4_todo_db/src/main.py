# pip freeze > 파일명(requirements.txt)
from fastapi import FastAPI
from fastapi import Request # template으로 갈 핸들러 함수 매개변수
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from starlette.responses import RedirectResponse #redirect
from models import ToDoRequest
from fastapi import Form # create(POST방식) 때 사용
from fastapi import HTTPException
import os
from database.repository import get_todos, get_todo, create_todo, update_todo, delete_todo

app = FastAPI()
BASE_DIR = os.path.dirname(os.path.abspath(__file__)) # 현 폴더의 절대경로
app.mount('/static',
          StaticFiles(directory=os.path.join(BASE_DIR, '../static')),
          name='static')
templates = Jinja2Templates(directory=os.path.join(BASE_DIR,
                                                   '../templates'))

@app.get('/')
@app.get('/todos')
@app.post('/todos')
async def get_todos_handler(request:Request,
                            order:str|None=None):
  todos = get_todos()
  if order and order.upper()=='DESC':
    todos = todos[::-1]
  return templates.TemplateResponse('todos.html', # todo 목록, todo 입력 form
                                    {'request':request,
                                     'todos':todos,
                                     'order':order.upper() if order else ''})
# 상세보기 : 없는 id 조회시 404 예외 발생
@app.get('/todos/{todo_id}', status_code=200)
async def get_todo_detail_handler(request:Request, todo_id:int):
  todo = get_todo(todo_id)
  if todo:
    return templates.TemplateResponse('todo.html',
                                    {'request':request,
                                     'todo':todo})
  raise HTTPException(status_code=404, 
                      detail='없는 id입니다')

@app.exception_handler(404)
def error_handler(requset:Request, exe:HTTPException):
  return templates.TemplateResponse('page_not_found.html',
                                    {'request':requset},
                                    status_code=404)

@app.post('/create')
async def create_todo_handler(todo:ToDoRequest=Form()):
  create_todo(todo)
  return RedirectResponse('/todos')

@app.delete('/delete/{todo_id}', status_code=200)
async def delete_todo_handler(todo_id:int):
  result = delete_todo(todo_id)
  if result:
    return result
  raise HTTPException(status_code=404,
                      detail='예외 페이지로 감')

@app.get('/update/{id}', status_code=200)
async def get_updatetodo_handler(request:Request, id:int):
  todo = get_todo(id)
  if todo:
    return templates.TemplateResponse('update.html',
                                    {'request':request,
                                     'todo':todo})
  raise HTTPException(status_code=404,
                      detail='예외 페이지로 가서 이 detail 메세지는 출력 안 함')

@app.patch('/update/{id}/{contents}/{is_done}', status_code=200)
async def update_todo_handler(id:int, contents:str, is_done:bool):
  result = update_todo(id, contents, is_done)
  if result:
    return result
  raise HTTPException(status_code=404,
                      detail='예외 페이지로 가서 이 detail 메세지는 출력 안 함')