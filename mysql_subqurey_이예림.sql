use mbasic;
show tables;
desc sub_userinfo;
select*from sub_userinfo;
alter table sub_userinfo modify ban char(2);
update sub_userinfo set sex='m', kor=10, eng=20, math=44, ban='C', sns='n' where no=6;

/*
1. 서브쿼리
- select 구문안에 select 구문
- 서브쿼리 결과가 하나이상 반환 시 in any all 사용

2. 형식
select 컬럼 from 테이블명 where 컬럼 in (select 문);
*/

-- 1. 평균나이 이상인 레코드 추출
-- select * from sub_userinfo where  age>=평균나이
-- 2. 평균나이
-- select avg(age) from sub_userinfo;
-- 3. 합치기
 select * from sub_userinfo where  age>=(select avg(age) from sub_userinfo);
-- basic 2 
 select ban, name, kor, eng, math from sub_userinfo where ban = ( select ban from sub_userinfo where name = 'first');
-- basic 3
 select ban, avg(kor) `kor`, avg(eng) `eng`, avg(math) `math` 
 from sub_userinfo where ban = ( select ban from sub_userinfo where name = 'first') group by ban ;
 
select*from emp;
select*from dept;
select sal from emp where ename = 'jones';
select *from emp where sal > 2978;
select *from emp where sal > (select sal from emp where ename='jones');
select*from emp where hiredate < (select hiredate from emp where ename='scott');
select empno, ename, job, sal, deptno, dname, loc from emp natural join dept where deptno=20 and sal > (select avg(sal) from emp); 
select *from emp where deptno in (20, 30);
select max(sal) from emp group by deptno order by deptno;
select*from emp where sal in (select max(sal) from emp group by deptno order by deptno);

-- 각 부서별 최고 급여와 동일한 급여를 받는 사원정보 조회
select * from emp where sal = any(select max(sal) from emp group by deptno);
-- 11
select sal from emp where deptno=30;
select * from emp where sal = any(select min(sal) from emp group by deptno);
select * from emp where sal>any(select min(sal) from emp where deptno=30);

/*
1. 다중행 연산자
-  in , any(some) ,  all
2. in  : 서브쿼리의 결과가 하나라도 일치하면 true
3. any : 서브쿼리의 결과가 하나이상이면 true
4. all : 서브쿼리의 결과가 모두 만족하면  true

2. any : 하나라도 일치하면 참  (선한개)
컬럼명  < any(1,2,3)            |(1)   |(2)   |(3)  ★     최대값보다 작다.
컬럼명  > any(1,2,3)          ★ |(1)   |(2)   |(3)  최소값보다 크다

3. all : 모두가 일치하면 참 (선 3개)
컬럼명  < all(1,2,3)          ★ |(1)   |(2)   |(3)        최소값보다 작다  
컬럼명  > all(1,2,3)             |(1)   |(2)   |(3)  ★       최대값보다 크다

*/

create table atest as select 1 num from dual
				union all select 2 from dual
                union all select 3 from dual
                union all select 4 from dual
                union all select 5 from dual
                union all select 6 from dual ;
                
select*from atest;
select num from atest where num <any (select num from atest where num in(3,4,5)) order by num;
-- 최대값보다 작다 1 2 3 4
select num from atest where num >any (select num from atest where num in(3,4,5)) order by num;
-- 최소값보다 크다 4 5 6
select num from atest where num <all (select num from atest where num in(3,4,5)) order by num;
-- 최소값보다 작다 4 5
select num from atest where num >all (select num from atest where num in(3,4,5)) order by num;
-- 최대값보다 크다 6




