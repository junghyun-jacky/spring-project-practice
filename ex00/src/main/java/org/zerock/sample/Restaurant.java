package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

// Chef 주입
// @Component -> 존재하는 클래스의 인스턴스(객체)를 생성한다. 직접 객체 생성할 필요가 없음.
// @Autowired -> 스프링에서 Chef 클래스의 객체 레퍼런스(참조,주소)를 Restaurant 객체에 주입한다.
@Component
@Data
public class Restaurant {
	// Setter 가 Chef를 가져와줌
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
}
