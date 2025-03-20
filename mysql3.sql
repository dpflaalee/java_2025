use mbasic;
select*from emp;
select*from emp where deptno=30 and ename like '%E' and sal not between 1000 and 2000;
select*from emp where comm is null and mgr is not null and job in ('MANAGER','CLERK') and ename not like '_L%';
select*from userinfo;
insert into userinfo (name, age) values ('first',55);
insert into userinfo (name, age) values ('third',66);
create table select_userinfo (select*from userinfo);
select * from select_userinfo ;
/*
select		필드1, 필드2 
from		테이블명
where		조건식
order by	[ 기준필드 asc(123 오름차순) | desc(321내림차순) ]
limit		몇개
*/
-- 정렬
select*from select_userinfo order by age desc; -- 내림 
select*from select_userinfo order by age asc; -- 오름
-- 연장자 3명
select*from select_userinfo order by age desc limit 3;
-- no 높은순 4
select*from select_userinfo order by no desc limit 4;
-- no 두번째로 높은순 2 (limit 어디서부터, 몇개)
select*from select_userinfo order by no desc limit 0,2; -- 6 5 
select*from select_userinfo order by no desc limit 1,2; -- 5 4
-- //////////////////////////////////////////////////////////////
select*from select_emp;
select*from select_emp where job = 'SALESMAN';
select ename, mgr, sal from select_emp;
select ename, mgr, sal from select_emp where job= 'SALESMAN';
select*from select_emp order by sal desc;
select*from select_emp order by job asc , sal desc;
select ename, sal, empno from select_emp where sal>=2000 order by empno desc;
select distinct job from select_emp ;
select empno `사원번호` , ename `이름`, job`담당업무` from select_emp;
select*from select_emp order by sal asc;
select*from select_emp order by sal desc;
select*from select_emp order by deptno asc , sal desc;
select*from select_emp order by deptno desc, ename asc;

-- 집계함수
create table group_userinfo select*from userinfo;
alter table group_userinfo modify sns char(2) default 'y';
update group_userinfo set kor=100, eng=100, math=99, ban='A', sns='n' where no=1;

select*from group_userinfo;
-- 기본
/*
select		필드1, 필드2 
from		테이블명
where		조건식
group by 그룹핑
having 조건식
order by	[ 기준필드 asc(123 오름차순) | desc(321내림차순) ]
limit		몇개

avg(칼럼명) 평균, max 최대값 , min 최소값 , sum 합계 , count 갯수
*/
select @@sql_mode;
set SESSION sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
select*from group_userinfo group by ban; -- 

-- 나이 평균
select avg(age) from group_userinfo;
-- 반별 인원
select ban, count(*) from group_userinfo group by ban;
-- 반별 국, 영, 수 총점
select ban, sum(kor) `국어총합`, sum(eng) `영어총합`, sum(math) `수학총합` from group_userinfo group by ban;
-- 반별 국영수 평균
select ban, avg(kor), avg(eng), avg(math) from group_userinfo group by ban;
-- 반별 나이 총합 / 나이 평균
select ban, sum(age), avg(age) from group_userinfo group by ban;

select ban, avg(kor), avg(eng), avg(math) from group_userinfo group by ban having avg(kor)>=89;
select ban, sum(age) `나이총합` , avg(age) `나이평균` from group_userinfo group by ban having avg(age)>=35 order by avg(age) desc;

-- /////////////////////////////
desc emp;
select*from emp;
select sum(sal) from emp;
select sum(comm) from emp;
select sum(distinct sal), sum(all sal), sum(sal) from emp;
select count(*) `데이터갯수` from emp;
select count(deptno) from emp where deptno=30;
select count(distinct sal), count(all sal), count(sal) from emp;
select count(comm) `추가사당 받는 사원` from emp where comm is not null;
select max(sal) `부서10 최대급여` from emp where deptno=10;
select min(sal) `부서10 최소급여` from emp where deptno = 10;

select max(hiredate) `부서20 최근입사일` from emp group by deptno having deptno=20 limit 1;
select min(hiredate) `부서20 제일 오래된 입사일` from emp group by deptno having deptno=20 limit 1;
select avg(sal) `부서30평군급여` from emp group by deptno having deptno=30;
select avg(distinct sal) `부서30중복제거급여평균` from emp group by deptno having deptno=30;
select deptno, job, avg(sal) `평균급여` from emp group by deptno, job order by deptno asc;
select deptno, job, avg(sal) `평균급여` from emp group by deptno, job having avg(sal)>=2000 order by deptno asc;
select deptno, job, avg(sal) `평균급여` from emp where sal<=3000 group by deptno, job having avg(sal)>=2000 order by deptno asc;
select deptno, job, count(*)`사원수`, max(sal) `최고급여` , sum(sal) `급여합`, avg(sal) `평균급여` from emp group by deptno, job order by deptno asc;

select deptno, job, avg(sal) `평균급여` from emp group by deptno, job having avg(sal)>=2000 order by deptno asc;

create table milk_order ( one int not null primary key auto_increment, oname varchar(20) not null, onum int not null, odate datetime default now(), oip varchar(100) not null);
desc milk_order;
-- 1. 값 삽입 ( oname, onum, oip) 'white',2,'127.0.0.1'
insert into milk_order (oname, num, oip) values ('white',2,'127.0.0.1');
-- 2. no 1인 데이터 조회
select*from milk_order where ono=1 ;
-- 3. 전체데이터 조회
select*from milk_order ;
-- 4. 해당번호의 이름과 개수 수정
update milk_order set oname='choco', num=2 where ono=1;
-- 5. 해당번호 데이터 삭제
delete from milk_order where ono=1;

