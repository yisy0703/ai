# FastAPI에서 post방식 요청파라미터를 보낼 때 데이터 검증
from pydantic import BaseModel

class ToDoRequest(BaseModel):
  contents : str | None=''
  is_done : bool | None=False