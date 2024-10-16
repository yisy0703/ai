let funVar = function(){
  console.log('매개변수 없는 함수 호출');
  console.log('TEST');
};
funVar = () => {
  console.log('1. 매개변수 없는 구현이 2줄 이상인 화살표 함수 호출');
  console.log('TEST');
};
funVar();
funVar = () => console.log('2. 매개변수 없는 구현이 1줄인 화살표 함수 호출');
funVar();
funVar = i => {
  console.log('3. 매개변수 1개이고, 구현이 2줄이상 화살표 함수 호출 값 :' + i);
  console.log('TEST');
};
funVar(10);
funVar = i => console.log('4. 매개변수 1개이고, 구현이 1줄인 화살표 함수 호출 : ' + i);
funVar(20);