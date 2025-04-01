package spring005_ex_board;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dao.BoardDao;
import com.company.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/java/config/root-context.xml")
public class Test2_boardDao {
	@Autowired ApplicationContext context;
	@Autowired DataSource dataSource;
	@Autowired BoardDao dao;
	
	@Test public void test() throws UnknownHostException {
		//delete
		BoardDto dto=new BoardDto();
		dto.setBno(2);
		System.out.println(dao.delete(dto));
		
		/*//update
		BoardDto dto=new BoardDto();
		dto.setBtitle("new"); dto.setBcontent("newContent"); dto.setBno(2);
		System.out.println(dao.update(dto)); */
		
		//select
		//System.out.println(dao.selectOne(2));
		
		/* //insert
		BoardDto dto=new BoardDto();
		dto.setBname("first"); dto.setBtitle("title"); dto.setBcontent("content");
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		System.out.println(dao.insert(dto)); 
		*/
		//selectall
		System.out.println(dao.selectAll());
	}
}
