package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long bno);
	
	public int update(ReplyVO reply);
	
	public int delete(Long bno);
	
	// MyBatis의 파라미터는 1개만 허용하므로 @Param 사용해서 여러개 사용할 수 있도록
	public List<ReplyVO> getListWithPaging(
	          @Param("cri") Criteria cri, 
	          @Param("bno") Long bno);

	public int getCountByBno(Long bno);
}
