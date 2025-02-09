from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
# 테이블 정의 시 필요
from sqlalchemy.orm import declarative_base
from sqlalchemy import Column, Integer, String, Boolean
# Oracle XE
DATABASE_URL = 'oracle+cx_oracle://scott:tiger@localhost:1521/?service_name=xe'
engine = create_engine(DATABASE_URL, echo=True)
SessionFactory = sessionmaker(autocommit=False,
                              autoflush=False,
                              bind=engine)
# Todo 테이블 정의
Base = declarative_base()
class ToDo(Base):
  __tablename__ = 'todo'
  id       = Column(Integer, primary_key=True)
  contents = Column(String(256), nullable=False)
  is_done  = Column(Boolean, default=False)

# 애플리케이션의 시작점이 이 파일일때만 실행
if __name__ == '__main__':
  Base.metadata.create_all(bind=engine) # 테이블 생성










