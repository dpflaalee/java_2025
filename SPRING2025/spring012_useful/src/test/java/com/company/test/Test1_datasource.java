package com.company.test;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dao.TestDao;
import com.company.dao.UserDao;
import com.company.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*-context.xml")
public class Test1_datasource {
	@Autowired ApplicationContext context;
	@Autowired DataSource ds;
	@Autowired TestDao dao;
	@Autowired UserDao udao;
	
	@Autowired UserService service;
	

	@Test public void sellectAll_Service() {System.out.println(service.selectAll());}
	
	@Test public void sellectAll() {System.out.println(udao.selectAll());}
	
	
	@Ignore public void test1() {System.out.println(ds);}
	@Ignore public void test2() {System.out.println(dao);}
}
