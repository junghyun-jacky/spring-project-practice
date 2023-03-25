package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);	// read (select)
		  
	public BoardVO get(Long bno);		// select bno
		  
	public boolean modify(BoardVO board);	// update
		  
	public boolean remove(Long bno);	// delete
		  
	// public List<BoardVO> getList();		// select *

	public List<BoardVO> getList(Criteria cri);	// 페이징
	
	public int getTotal(Criteria cri);
}
