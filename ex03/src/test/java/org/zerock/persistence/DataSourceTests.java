package org.zerock.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// 스프링이 실행하는 역할을 할 것이라는 것을 표시
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j	// 로그창을 띄울 수 있도록
public class DataSourceTests {

//	@Autowired
//	private DataSource dataSource;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try(SqlSession session = sqlSessionFactory.openSession();
			Connection con = session.getConnection();){
			log.info(session);
			log.info(con);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
