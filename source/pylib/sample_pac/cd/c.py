# sample_pac/cd/c.py - ab/a.py을 참조
from ..ab import a
# .. 상위폴더
# . 현재폴더

def nice():
  print('sample_pac/cd안의 C모듈안의 nice')
  a.hello()