package org.zerock.mapper;

import java.util.List;

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
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
    public void testPaging() {
        Criteria cri =new Criteria();
        cri.setPageNum(2);
        cri.setAmount(10);
        List<BoardVO> list = mapper.getListWithPaging(cri);
        list.forEach(board->log.info(board));
    }
	
	@Test
	public void testInsert() {
		
		// BoardVO 저장
		BoardVO board = new BoardVO();
		board.setTitle("새 제목");
		board.setContent("새 내용");
		board.setWriter("새 작성자");
		
		// sql 쿼리에 삽입
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		// BoardVO 저장
		BoardVO board = new BoardVO();
		board.setTitle("select 새 제목");
		board.setContent("select 새 내용");
		board.setWriter("select 새 작성자");
		
		// sql 쿼리에 삽입
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(28L);	// 28번 레코드를 가져옴, bno가 Long 래퍼클래스였어서 28L 로 작성
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		log.info(mapper.delete(28L));
	}
	
	@Test
	public void testUpdate() {
		// BoardVO 저장
		BoardVO board = new BoardVO();
		board.setBno(23L);
		board.setTitle("수정 제목");
		board.setContent("수정 내용");
		board.setWriter("user00");
		
		// sql 쿼리에 삽입
		int count = mapper.update(board);
		
		log.info("UPDATE COUNT : " + count);
	}
	
	@Test
	public void testSearch() {
	    Criteria cri = new Criteria();
	    cri.setKeyword("새로");
	    cri.setType("TC");
	
	    List<BoardVO> list = mapper.getListWithPaging(cri);
	
	    list.forEach(board -> log.info(board));
	}

}
