﻿// 2.js
// 다른이름으로 저장(utf-8인코딩방법으로 저장)
/* 동적인 부분(JavaScript) */
name = prompt("이름은 ?"); // 취소를 클릭하면 'null'리턴
if (name != "null" && name != "") {
    document.write(name + "님 반갑습니다<br>");
}
