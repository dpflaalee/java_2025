package spring005_ex_board;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")
public class TestDao {
	
	@Autowired ApplicationContext context;
	@Autowired DataSource datasource;
	
	@Test public void test1() {System.out.println(context);}
	@Ignore public void test2() {System.out.println(datasource);}
	
	//@Autowired BtDao dao;
	//@Test public void test3() {System.out.println(dao.readTime());}
}
