# 정의어 DDL - create alter drop - cad
#조작어 DML - insert select update delete - crud
#제어어 DCL - grant, revoke

#실습1 insert
show tables;
desc userinfo;

#1-1 구조와 순서를 알고 있을 때
insert into userinfo values(1, 'first', 11);
insert into userinfo values('second',22,2); # 필드 순서 안맞음
select *from userinfo;

#원하는 필드만 데이터 입력
insert into userinfo (name, age) values('second',22);
select*from userinfo;

insert into userinfo (age, name) values(33,'third');
select*from userinfo;

insert into emp values(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20);
insert into emp values(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30);
insert into emp values(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250,  500, 30);
insert into emp values(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, NULL,   20);
insert into emp values(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400,   30);
insert into emp values(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01',  2850, NULL,   30);
insert into emp values(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, NULL,   10);
insert into emp values(7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19 ', 3000, NULL,   20);
insert into emp values(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17',  5000, NULL,   10);
insert into emp values( 7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08',  1500,    0,   30);
insert into emp values( 7876, 'ADAMS', 'CLERK', 7788, '1987-05-23', 1100, NULL,   20);
insert into emp values(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, NULL,   30);
insert into emp values(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000, NULL,   20);
insert into emp values(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, NULL,   10);
select*from emp;

insert into dept values(10, 'ACCOUNTING', 'NEW YORK');
insert into dept values(20, 'RESEARCH', 'DALLAS' );
insert into dept values(30, 'SALES', 'CHICAGO');
insert into dept values(40, 'OPERATIONS', 'BOSTON');
select*from dept;

insert into salagrade values(1,700,1200);
insert into salagrade values(2,1201,1400);
insert into salagrade values(3,1401,2000);
insert into salagrade values(4,2001,3000);
insert into salagrade values(5,3001,9999);
select*from salagrade;

insert into userinfo (name, age) values('forth',44);
select*from userinfo;

/*
update 테이블명
set 필드1 = 값1, 필드2 = 값2 
where 조건 
*/
# 2-1 전체 데이터 수정
set sql_safe_updates=0; -- error code 1175
update userinfo set age = 0;
select*from userinfo;

#2-2 바꿀 데이터 여러개
update userinfo
set age = 11
where no=1;
select*from userinfo;
update userinfo set age=22, name='two' where no=2;
update userinfo set name='second' where no=2 and age=22;

update userinfo set name='third', age=33 where no=3 and age=10; -- 조건이 안맞으면 실행되지 않음
update userinfo set name = 'forth', age=44 where no=4 and name='first';

insert into score values(1, 'aaa', 100 , 100, 100, 100, null, null, null);
insert into score values(2, 'bbb', 90 , 98, 88, 100, null, null, null);
insert into score values(3, 'ccc', 70 , 20, 78, 80, null, null, null);
insert into score values(4, 'ddd', 78 , 89, 68, 98, null, null, null);
insert into score values(5, 'abc', 89 , 98, 69, 77, null, null, null);
select*from score;
update score set sjava=90, sjsp=90, sspring=90 where sname='ccc';
update score set semail='admin@gmail.com';
update score set sstotal = (sjava+sjsp+sspring+sproject);
update score set ssavg = sstotal/4;
update score set semail='first@gmail.com'where ssavg=100;
update score set sjava=92, sjsp=78 where sname='bbb';
alter table score modify ssavg double;
update score set semail='second@gmail.com', sname='second' where ssavg=89.5;
update score set semail='ccc@gmail.com' where sname='ccc';
update score set semail='blackstdudent@gmail.com' where sproject<80;
update score set semail='hello@gmail.com'where ssavg=89.5 and sproject=98;

-- -- -- 구조+데이터 복사
create table userinfo_delete select*from userinfo;
alter table userinfo_delete add primary key(no);
alter table userinfo_delete modify no int not null auto_increment;

desc userinfo_delete;
select*from userinfo;
/*
delete from 테이블명
where 조건식
*/

#3-1
delete from userinfo_delete where age=11;
select*from userinfo_delete;
delete from userinfo_delete where name = 'second' and age=22;
-- 전쳊데이터 삭제
delete from userinfo_delete;

create table emp_del select*from emp_del;
delete from emp_del where ename='SALESMAN';
delete from emp_del where job='MANAGER' and ename='JONES';
delete from emp_del;