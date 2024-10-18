function Student(name, kor, mat){ // 생성자함수
  this.name = name;
  this.kor = kor;
  this.mat = mat;
}
Student.prototype.getSum = function(){
  return this.kor + this.mat;
};
Student.prototype.toString = function(){
  return this.name + ' (' + this.kor + ',' + this.mat + ','+this.getSum() +')';
};
var students = [new Student("홍", 70, 90),
  new Student("박", 99, 99),
  new Student("김", 56, 61),
  new Student("윤", 99, 97),
];
var studentsCopy = [...students]; // 깊은 복사
studentsCopy.sort(function(left, right){
  return right.getSum() - left.getSum(); // 총점기준으로 내림차순 정렬
});
console.log('원본');
students.forEach((data, idx)=>{
  console.log(idx + ',' + data.toString());
});
console.log('정렬된 복사본')
studentsCopy.forEach((data, idx)=>{
  console.log(idx + ',' + data.toString());
});