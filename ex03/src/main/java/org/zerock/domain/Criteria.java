package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {	// 페이징 기법, sql문의 rownum을 사용하여 실행 결과에 번호를 준다. 검색의 기준이 되는 클래스

	private int pageNum; // 페이지 번호
	private int amount; // 한 페이지에 보여줄 데이터 개수
	
	private String type;	// 검색 조건
	private String keyword;	// 검색어

	// 생성자
	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		
		
	}
	
	public String[] getTypeArr() {	// 검색 조건을 배열로 만들어서 한번에 처리하기 위해
		return type == null? new String [] {}: type.split("");
	}

}
