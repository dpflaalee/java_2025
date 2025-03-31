package spring002_di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.ioctest3.AnimalFarm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/test3.xml")
public class DiTest3 {
	
	@Autowired ApplicationContext context;
	@Test public void test() {
		AnimalFarm farm = context.getBean("animalFarm", AnimalFarm.class);
		farm.print();
	}
}
/*
org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'AnimalFarm' available
	
 */