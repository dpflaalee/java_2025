show databases;
use mbasic;
show tables;
select*from userinfo_ex;
delete from userinfo_ex where no=8;


-- 전체 데이터 검색
select*from userinfo_ex;
-- 부분 검색
select name, age from userinfo_ex;
-- 중복 제거
select distinct name from userinfo_ex;
-- 별명
select name as `이름`, age as `나이` from userinfo_ex;

-- where 조건 ( = 같다, != <> 다르다
select*from userinfo_ex where name = 'second';
select*from userinfo_ex where name != 'second';
select*from userinfo_ex where name <> 'second';

-- and, between and / or, in
select*from userinfo_ex where age>=22 and age<=33;
select*from userinfo_ex where age between 22 and 33;

select*from userinfo_ex where age=22 or age=33;
select*from userinfo_ex where age in(22,33);

-- null 검색
alter table userinfo_ex  modify age int;
desc userinfo_ex;

insert into userinfo_ex (name) values ('seven');
select*from userinfo_ex;
## null 값이 비어있다는 상태 = !=으로는 조건을 걸 수 없음
select*from userinfo_ex where age is null;

select*from userinfo_ex where age<22 or age>33;
select*from userinfo_ex where age not between 22 and 33;

select*from userinfo_ex where age=22 or age=33;
select*from userinfo_ex where age not in(22,33);

-- like 문자열 검색
select*from userinfo_ex where name='first';
select*from userinfo_ex where name like'f%'; -- 시작하는 애
select*from userinfo_ex where name like'%t'; -- 끝나는 애
select*from userinfo_ex where name like'%i%'; -- 포함하는 애
select*from userinfo_ex where name like'_e%';  -- 두번째 글자가 e

create table select_emp (select*from emp);
desc select_emp;
alter table select_emp modify empno int not null primary key auto_increment;
select*from emp;

select*from select_emp  where deptno=30;
select*from select_emp where deptno=30 and job='SALESMAN';
select*from select_emp where deptno=30 or job='CLERK';
select*from select_emp where sal*12 = 36000;
select*from select_emp where sal>=3000;
select*from select_emp where ename >='F%';
select*from select_emp where ename <='FORD';
select*from select_emp where sal != 3000;
select*from select_emp where sal <> 3000;

select*from select_emp where not sal = 3000;
select*from select_emp where job = 'CLERK'or job = 'MANAGER' or job =  'SALESMAN';
select*from select_emp where job in('CLERK','MANAGER', 'SALESMAN');
select*from select_emp where job<>'CLERK' and job !='MANAGER' and job<> 'SALESMAN';
select*from select_emp where job not in ('CLERK','MANAGER', 'SALESMAN');
select*from select_emp where 2000<=sal and sal<=3000;
select*from select_emp where  sal between 2000 and 3000;
select*from select_emp where  sal not between 2000 and 3000;
select*from select_emp where not sal >= 2000 and sal<=3000;
select*from select_emp where empno=7499 and deptno=30;

select*from select_emp where job='SALESMAN' or deptno=20;
select*from select_emp where sal>=2500 and job='ANALYST';
select*from select_emp where deptno in (10,20);
select*from select_emp where deptno not in (10,20);
select*from select_emp where ename like 'S%';
select*from select_emp where ename like '_L%';
select*from select_emp where ename like '%AM%';
select*from select_emp where ename not like '%AM%';
-- 29 숫자+null 계산 x
select ename, sal, sal*12+comm `annal`, comm from select_emp where ename like '%AM%';
select*from select_emp where comm is null;
-- select*from select_emp where comm = null; 

select*from select_emp where comm is null;
select*from select_emp where  mgr is not null;
 select*from select_emp where sal>null; 
 select*from select_emp where comm is null;
 select*from select_emp where ename like '%S';
 select*from select_emp where deptno=30 and job='SALESMAN';
 select*from select_emp where deptno in(20,30) and sal>2000;
 select*from select_emp where sal>=20 and sal<=3000;
 select*from select_emp where deptno=30 and ename like '%E%' and sal between 1000 and 2000;
 select*from select_emp where comm is null and mgr is not null and job in ('MANAGER','CLERK') and ename not like '_L%';