package com.thejoa.boot3.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	// 1. select(기본작업)--> @Query 테이블명 : Board
//	@Query(value="select*from board order by id desc", nativeQuery=true) //버전따라 오류나기도 해서 권장하지 않음
	@Query("select b from Board b order by id desc")
	List<Board> findAllByOrderBydesc();
	
	// 2. insert, update, delete --> @Modifying @Transactional @Query
	@Modifying // 2-1. 삽입,수정,삭제 쿼리는 변경작업 
	@Transactional //2-2. rollback 활성화/안붙여도 가능할 순 있으나... 없으면 데이터 손상 있을 수 있음
	@Query("delete from Board b where b.id= :id and b.bpass= :bpass")
	int deleteByIdAndBpass(@Param("id") Long id, @Param("bpass") String bpass);
	//2-3. @Param("id") 쿼리의 변수명과 동일하면 생략가능
	//2-3. deleteByIdAndBpass(Board board) XXX 객체파라미터 지원안함
	
	@Modifying @Transactional
	@Query("update from Board b set b.btitle=:btitle, b.bcontent=:bcontent where b.id= :id and b.bpass= :bpass")
	int updateByIdBpass(Long id, String bpass, String btitle, String bcontent);
	
}  
// JpaRepository<Member, Long>   테이블, pk의 자료형
/*
 https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation
*/









/*
mysql> desc member;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| age         | int          | NO   |     | NULL    |                |
| create_date | datetime(6)  | YES  |     | NULL    |                |
| name        | varchar(255) | NO   |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)
*/