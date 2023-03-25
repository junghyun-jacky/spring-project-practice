package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	// sql문을 작성할 수 있는 어노테이션
	// @Select("select * from tbl_board")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);	// 페이지, 페이지당 데이터 개수
	
	public void insert(BoardVO vo);	// BoardVO에 데이터 삽입 - BoardMapper.xml에서 로직 처리
	
	public void insertSelectKey(BoardVO vo);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);	// 리턴할 때는 int로 해도 무관
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);	// 전체 데이터의 갯수 처리
	
}
