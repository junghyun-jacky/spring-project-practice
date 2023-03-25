package org.zerock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.domain.Ticket;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// 스프링이 실행하는 역할을 할 것이라는 것을 표시
@WebAppConfiguration	// 웹을 보기 때문에
@ContextConfiguration({
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
    "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j	// 로그창을 띄울 수 있도록
public class SampleControllerTests {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	// 가짜 mvc, URL과 파라미터를 브라우저에서 사용하는 것처럼 만들어 Controller를 실행
	private MockMvc mockMvc;
	
	// 테스트 전에 매번 실행 
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testConvert() throws Exception {
	
	    Ticket ticket = new Ticket();
	    ticket.setTno(123);
	    ticket.setOwner("Admin");
	    ticket.setGrade("AAA");
	    //GSON 라이브러리를 이용해서 JSON 데이터로 변환 
	    String jsonStr = new Gson().toJson(ticket);
	    
	    log.info(jsonStr);
	    
	    mockMvc.perform(post("/sample/ticket")
	        .contentType(MediaType.APPLICATION_JSON)
	        .content(jsonStr))
	        .andExpect(status().is(200));
	  }

	
}