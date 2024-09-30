-- DCL(계정생성, 권한부여,  권한박탈, 계정삭제)
-- DDL(제약조건FK, 시퀀스 없음)
-- DML(outer join, and=&&, or=||, 일부단일행함수, rownum이 없어 top-N구문이 다름)

-- Java에서 쓸 데이터 넣어 보고 연습해 보기
show databases;
-- ★ ★ ★ DCL (계정 생성, 권한부여, 계정 삭제)
create user user01 identified by 'password'; -- 계정 생성
grant all on *.* to user01; -- 권한부여
revoke all on *.* from user01; -- 권한 박탈
drop user user01; -- 계정 삭제
show databases;
use world; --  world 데이터 베이스 영역으로 들어감
show tables; -- 현재 들어와 있는 데이터베이스 안의 테이블들
create database dev_user; -- 데이터베이스 생성(dev_user)
show databases;
use dev_user;
show tables;
select database(); -- 현재 들어와 있는 데이터베이스 명

-- ★ ★ ★ DDL
create table emp (
	empno numeric(4) primary key,
    ename varchar(6) not null,
    nickname varchar(6) unique,
    sal numeric(7,2) check(sal>0),
    comm numeric(7,2) default 0
);
desc emp;
insert into emp (empno, ename, nickname, sal)
	values (1111, '김수한무거북', '두루미거북이', 20);
select * from emp;
drop table if exists emp;

-- major : mCode(학과번호,인위적pk), mName(학과이름), mOffice(학과사무실)
-- student : sNo(학번,pk), sName(이름), mCode(학과번호, fk)








