// false로 해석되는 값 : 0, '', undefined, NaN, null
var i;
console.log(Boolean(i));
console.log(Boolean(0));
console.log(Boolean(''));
console.log(Boolean(NaN));
console.log(Boolean(null));
console.log(); // 개행
console.log(Boolean(-999));
console.log("빈스트링==false의 결과 : " + (""==false));
console.log("빈스트링===false의 결과 : " + (""===false));