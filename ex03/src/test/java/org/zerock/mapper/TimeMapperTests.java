package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// 스프링이 실행하는 역할을 할 것이라는 것을 표시
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j	// 로그창을 띄울 수 있도록
public class TimeMapperTests {

	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("test time............");
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
}

