package com.company.test.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board, Long>{
	//Q3 id를 기준으로 내림차순으로 정렬하는 sql
	@Query("select b from Board b order by id desc")
	List<Board> findAllByOrderByIddesc();
	
	//Q4 id와 pass가 같으면 삭제하는 sql
	@Modifying @Transactional
	@Query("delete from Board b where b.id= :id and b.bpass= :bpass")
	int deleteByIdAndBpass(@Param("id")Long id, @Param("bpass")String bpass);
	
	//Q5 id와 pass가 같으면 btitle과 bcontent를 수정하는 sql
	@Modifying @Transactional
	@Query("update Board b set b.btitle=:btitle, b.bcontent=:bcontent where b.id=:id and b.bpass=:bpass")
	int updateByIdAndBpass(Long id, String bpass, String btitle, String bcontent);
	
}
