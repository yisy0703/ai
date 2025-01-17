# pip install fastapi
# pip install uvicorn
# pip install jinja2
# pip install python-multipart
from fastapi import FastAPI, Request # 템플릿 사용
from fastapi import File, UploadFile # 파일첨부
from fastapi.staticfiles import StaticFiles # static mout
from fastapi.templating import Jinja2Templates # 템플릿 지정
from starlette.responses import RedirectResponse # redirect
from starlette.exceptions import HTTPException # 예외발생
from fastapi.responses import FileResponse # 파일 다운로드

import os
import datetime












