use mbasic;
create table join_userban(no int not null primary key auto_increment, name varchar(20) not null, ban char(2));
insert into join_userban (name, ban) values ('first','A');
select*from join_userban;
update join_userban set ban='D' where no>=7;
delete from join_userban where no>=7;
select ban, count(ban) `학생수` from join_userban group by ban;

select*from userinfo;

-- 데이터베이스 언어 
# DDL - create alter drop
# DML - insert select update delete
# DCL - grant revoke

# e(entity : 테이블)r(relation : 관계) 속성 : pk, fk
# join : 두개이상의 테이블들을 연결해서 데이터를조회
-- 테이블간의 연결고리 (pk, fk)

# 종류 : inner join , outer join
create table j_userinfo select*from userinfo;
select*from j_userinfo;
select*from join_userban;
# 1) =join > 사용 시... select 칼럼명<소속을 명시해야 함
select a.no, a.name, a.age, b.ban
from j_userinfo a , join_userban b
where a.no = b.no;

# 2) join on
select a.no, a.name, a.age, b.ban
from j_userinfo a join join_userban b on (a.no = b.no);

# 3) join using > 칼럼명이 동일할 시 사용가능
select a.no, a.name, a.age, b.ban
from j_userinfo a join join_userban b using(no);

# 4) natural join > 알아서 연결부위 찾아서 연결해줌
select no, name, age, ban
from j_userinfo natural join join_userban;

# question2)  inner join을 이용하여 join_userinfo
 -- 테이블의 20세이상 40세 이하 학생의 번호, 이름, 나이, 반을 출력하시오.   번호.이름

#>>> (1) = join
select a.no, a.name, a.age, b.ban from j_userinfo a, join_userban b where a.no=b.no and age between 20 and 40;
#>>> (2) join  on
select a.no, a.name, a.age, b.ban from j_userinfo a join join_userban b on(a.no=b.no) where age between 20 and 40;
#>>> (3) join  using
select a.no, a.name, a.age, b.ban from j_userinfo a join join_userban b using(no) where age between 20 and 40;
#>>> (4) natural join 
select no, name, age, ban from j_userinfo natural join join_userban where age between 20 and 40;

# right join
select b.no, b.name, b.ban, a.age from join_userban b right join  j_userinfo a on a.no=b.no; 

# left join
select b.no, b.name, b.ban, a.age from join_userban b left join  j_userinfo a on a.no=b.no; 

select*from emp;
select*from dept;
select*from salagrade;

select*from emp, dept order by empno; -- 기준점을 안잡으면 emp*dept 갯수로 출력
select empno, ename, job, mgr, hiredate, sal, comm, deptno, dname, loc from emp natural join dept;
select empno, ename, job, mgr, hiredate, sal, comm, deptno, dname, loc 
from emp e join dept d using(deptno);
select empno, ename, e.deptno, dname, loc from emp e, dept d where e.deptno=d.deptno; -- 앞쪽 deotno 소속명시 안함
select empno, ename, e.deptno, dname, loc from emp e join dept d using(deptno) where sal>=3000;
select empno, ename, job, e.mgr, hiredate, e.sal, comm, e.deptno, s.grade, s.losal, s.hisal  from emp  e  join salagrade s on sal between losal and hisal order by losal, hisal;
select e.empno, e.ename, e.mgr, e2.empno `MGR NO`, e2.ename `MGR NAME` from emp e, emp e2, salagrade s 
where e.mgr=e2.empno and e.sal between s.losal and s.hisal order by e2.empno;
select e.empno, e.ename, e.mgr, e2.empno`MGR NO`, e2.ename `MGR NAME` from emp e left join emp e2 on e.mgr=e2.empno;
select e.empno, e.ename, e.mgr, e2.empno`MGR NO`, e2.ename `MGR NAME` from emp e right join emp e2 on e.mgr=e2.empno; -- 조건에서 동일한 값이 없는 행도 null로 출력

select e1. empno, e1.ename, e1.mgr, e2.empno `MGREMPNO`, e2.ename `MGRENAME`
from emp e1 left join emp e2 on e1.mgr=e2.empno order by e2.ename;

select e1. empno, e1.ename, e1.mgr, e2.empno `MGREMPNO`, e2.ename `MGRENAME`
from emp e1 right join emp e2 on e1.mgr=e2.empno;
-- 오른쪽의 테이블 값 보장

select empno, ename, job, mgr, sal,comm,deptno,dname,loc from emp join dept using(deptno) where sal>=3000;
select empno, ename, job, mgr, sal,comm, dept.deptno, dname, loc from emp join dept on(emp.deptno=dept.deptno) where sal<=3000;
select b.deptno, b.dname, a.empno, a.ename, a.sal from emp a join dept b where a.deptno=b.deptno and sal>2000;
select deptno, dname, empno, ename, sal from emp natural join dept where sal>2000;
select d.deptno, d.dname, avg(e.sal), max(e.sal), min(e.sal), count(*)
from emp e, dept d
where e.deptno=d.deptno group by deptno, dname order by deptno, dname;
select deptno, dname, avg(sal), max(sal), min(sal), count(sal)
from emp join dept using(deptno)group by deptno, dname order by deptno, dname; 
select d.deptno, dname, empno, ename, job, sal from dept d left join emp on emp.deptno=d.deptno order by emp.deptno asc, dname asc;
select d.deptno, dname, empno, ename, job, sal from dept d right join emp on emp.deptno=d.deptno order by emp.deptno asc, dname asc;
select d.deptno, dname, e.empno, e.ename, e.mgr, e.sal, e.deptno, s.losal, s.hisal, s.grade, e2.empno `MGR EMPNO`, e2.ename `MGR ENAME` 
from emp e 
right join dept d on(e.deptno = d.deptno) 
left join salagrade s on (e.sal between s.losal and s.hisal)
left join emp e2 on(e.mgr=e2.empno) order by d.deptno;

