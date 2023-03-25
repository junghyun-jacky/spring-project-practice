package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// 스프링이 실행하는 역할을 할 것이라는 것을 표시
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j	// 로그창을 띄울 수 있도록
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);	 
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("Service 새로 작성하는 글");
		board.setContent("Service 새로 작성하는 내용");
		board.setWriter("새 작성자");
		service.register(board);
	
		log.info("생성된 게시글의 번호 : " + board.getBno());
	}
	
	@Test
	public void testGetList() {	// 일반 리스트 -> 페이징
		// 람다식이라서 아래 코드 자체에서 board가 선언된 것
		// service.getList().forEach(board->log.info(board));
		service.getList(new Criteria(2, 10)).forEach(board->log.info(board));
	}
	
	@Test
	public void testGet() {
		log.info(service.get(21L));
	}
	
	@Test
	public void testDelete() {
		log.info("REMOVE RESULT" + service.remove(21L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(21L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("새 제목 수정");
		log.info("MODIFY RESULT" + service.modify(board));
	}
	
}
