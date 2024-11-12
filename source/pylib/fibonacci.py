'''
피보나치 수열 관련 함수 (테스트 : python fibonacci.py 100)
'''
def fibo_print(n):
  'n미만의 피보나치 수열을 print (ex)0, 1, 1, 2, 3, 5, ...'
  a, b = 0, 1
  while a<n:
    print(a, end=' ')
    a, b = b, a+b
  print() # 개행

if __name__ == '__main__':
  import sys
  # sys.argv : 명령행 인수
  if len(sys.argv) > 1:
    fibo_print(int(sys.argv[1]))
  else:
    fibo_print(100)