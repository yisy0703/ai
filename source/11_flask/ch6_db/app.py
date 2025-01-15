from flask import Flask, render_template # 요청경로를 html로 응답
from flask import jsonify # 요청경로를 json으로 응답
from flask import Response, json # json응답할 경우 한글깨짐 해결
import cx_Oracle

app = Flask(__name__)

dsn = cx_Oracle.makedsn('localhost', 1521, 'xe')
conn = cx_Oracle.connect(user='scott',password='tiger', dsn=dsn)

@app.route('/')
