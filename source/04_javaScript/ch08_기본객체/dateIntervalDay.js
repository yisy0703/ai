// prototype에 함수 추가시 화살표함수 사용 불가
Date.prototype.getIntervalDay = function(otherDay){
  // now.getIntervalDay(limitDay) => now가 this, limitDay가 otherDay
  // if(otherDay>this){
  //   var intervalMilliSec = otherDay.getTime() - this.getTime();
  // }else{
  //   var intervalMilliSec = this.getTime() - otherDay.getTime();
  // }
  var intervalMilliSec = Math.abs(this.getTime() - otherDay.getTime());
  return Math.trunc(intervalMilliSec / (1000*60*60*24));
}
// var today = new Date();
// var thatDay = new Date(2024, 9, 11, 14, 0, 0);
// console.log(today.getIntervalDay(thatDay));
// console.log(thatDay.getIntervalDay(today));