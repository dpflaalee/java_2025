use mbasic;
desc emp;
select deptno, job, avg(sal) `평균급여` from emp where sal<=3000 group by deptno, job having avg(sal)>=2000;
select deptno, job, count(*) `사원수`, max(sal) `최고급여`, sum(sal) `급여합`, avg(sal) `평균급여`from emp group by deptno, job order by deptno asc;

-- ■ function
#1. Number(ceil-올림 floor-내림 round(수, 자리)-반올림 mod-나머지)
select ceil(1.1) `올림`, floor(1.9) `내림`, round(1.5) `반올림`, mod(10,3)`나머지`;

#2. String ( length upper/lower instr(문자열,찾을문자열) substr(문자열,시작,갯수) left(문자열, 갯수) 
-- concat(문자열,문자열) trim()litrm rtrim replace(문자열,찾아서,바꾸기) repeat(문자열,몇번) 빈칸채우기 
-- lpad rpad
select length('abc') ;
select 'upper', upper('upper') , lower('lower');
select instr('abc','b') `b 위치`, instr('abc','ab') `ab 위치`, instr('abc','ac') `ac 위치`; -- 못찾으면 0
select left('abc',1) , right('abx',2);
select concat('hello', 'mysql');
select trim(' a  b  c ' );
select concat('#', trim(' a  b  c '  ), '#') , 
	   concat('#', ltrim(' a  b  c '  ), '#'), 
	   concat('#', rtrim(' a  b  c '  ), '#');
select replace('hellow sally', 'sally', 'alpha');
select repeat ('*',5);
-- 빈칸채우기
select lpad('abc',10,'#'),rpad('abc',10,'#');

#3. date
select now(); -- 시스템 현재시각조회 
select current_time(); -- 현재시각
select weekday(now()); -- 월요일 0부터 시작 필드명이 들어가기도
select weekday("2025-03-21");
select date_format(now(), "%Y-%m-%d %H:%i:%s"); -- 년월일 시분초
select date_add(now(), interval -10 day); -- n일전 n일후
select date_add(now(), interval -3 hour); 
select datediff('2025-03-22','2025-03-21'); -- 날짜 차이 체크
select timestampdiff(hour, '2025-03-22','2025-03-21'); -- 시간차이

#4. if / case
/*
if (조건, 참, 거짓)
case
when 조건1 then 상태1
else 모든조건 해당 안할 경우
end
*/

create table control (no int); 
insert into control values(1),(2),(3);
select*from control ;

select no, if(no=1, '1이다' , '1이 아니다') from control;
select no, if(no>1, '1보다 크다' , '1보다 작다') from control;
select no , case 
when no=1 then '1이다' 
when no=2 then '2이다'
when no=3 then '3이다'
else '1,2,3 아니다'
end `state` from control;


select*from if_userinfo;
alter table if_userinfo  add sns char(1) ;
alter table if_userinfo modify no int primary key auto_increment ;
update if_userinfo set sns='y' where no=2;

select * , if(sns='y', '수신유지' , '수신거부') `수신여부상태` from if_userinfo ;
select sum(if(sns='y',1,0)) from if_userinfo;
select *, if(age<19 , '미성년자' , '성인')`성인여부` from if_userinfo;
select ename, deptno, case 
when deptno=10 then 'ACCOUNTION'
when deptno=20 then 'RESERCH'
when deptno=30 then 'SALES'
end `부서이름` from emp;
select ename, job, case 
when job='CLERK' then '판매원'
when job='SALESMAN' then '영업사원'
else '사원'
end`job2` from emp;

create table date_userinfo(no int not null primary key auto_increment, name varchar(100) not null, age int not null, date datetime default now());
select*from date_userinfo;
insert into date_userinfo (name, age, date) values ('ddd',44,'2022-9-30 00:00:00');
select name, date from date_userinfo where date<'2022--11--01'; 
select name, daete, date_add(date, interval 30 day)  from date_userinfo where month(date)=12;


select round(123.4578), round(123.4578, -1), round(123.4578,1), round(123.4578,2); 
select ceil(123.4578), floor(123.4578);

select*from s_userinfo ;
alter table s_userinfo add email varchar(100) ; 
alter table s_userinfo modify no int not null primary key auto_increment;
update s_userinfo  set name='bca', email='bca@gmail.com' where no=6;

select name `이름`, length(name) `갯수` from s_userinfo ;
select name , left(name, 1) `첫번째글자` , right(name, 1)`마지막글자` from s_userinfo ;
select name, replace(name, 'aaa', 'aaa 1등')  from s_userinfo; 
select concat(name, '는 개발자입니다.') `직업` from s_userinfo ;
select upper(name) `대문자`, lower(name) `소문자` from s_userinfo ;
select name, instr(name, 'b') from s_userinfo where age>=40;
select name, instr(name,'b') from s_userinfo where age>=40 order by age desc limit 2;
select name, concat( left(name,1), '*', right(name,1) ) from s_userinfo;
select name, concat(left(name,1) , repeat('*',length(name)-2), right(name,1) ) `test` from s_userinfo;

