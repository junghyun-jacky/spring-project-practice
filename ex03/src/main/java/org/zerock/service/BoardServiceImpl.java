package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor	// 모든 필드 값을 파라미터로 받는 생성자를 만들어줌
public class BoardServiceImpl implements BoardService {

	// DI -> 의존성 (*.xml) 주입
	// 주입받는 생성자 만들어짐
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {	// BoardMapper.xml의 insert 가져가 쓸 것
		log.info("register....." + board);
        mapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get......" + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify...........");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove...........");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get list with criteria");
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList...........");
//		return mapper.getList();	// 인터페이스에 있는 getList()를 구현
//	}
	
	

}
