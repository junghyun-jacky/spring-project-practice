package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {	
	// BoardController는 BoardService 객체와 연동해야하므로, 의존성 처리도 진행됨 
	// --> 생성자 만드는 어노테이션 @AllArgsConstructor 필요
	// 생성자를 만들지 않을 땐 @Setter(onMethod_ = {@Autowired})로 처리

	private BoardService service;	// 의존성 처리
	
	@GetMapping("/list")
    public void list(Criteria cri, Model model) {	// 리스트의 전달자 model
            log.info("list" + cri);
            model.addAttribute("list", service.getList(cri));
           // model.addAttribute("pageMaker", new PageDTO(cri, 123));

            int total  = service.getTotal(cri);
                log.info("total: "+ total);
               model.addAttribute("pageMaker", new PageDTO(cri, total));

     }
	
	@PostMapping("/register") //			화면이동 위해
	 public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register: " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";	// redirect: 접두어를 사용하여 스프링 MVC가 내부적으로 response.sendRedirect()
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@GetMapping({"/get", "/modify"})	// 리스트 이므로 중괄호 필요
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
	    log.info("/get or modify");
	    model.addAttribute("board", service.get(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify: " + board);
		if(service.modify(board)) {	// 
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addFlashAttribute("pageNum", cri.getPageNum());
		rttr.addFlashAttribute("amount", cri.getAmount());
		rttr.addFlashAttribute("type", cri.getType());
		rttr.addFlashAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {
	    log.info("remove..." + bno);
	    if (service.remove(bno)) {
	      rttr.addFlashAttribute("result", "success");
	    }
		rttr.addFlashAttribute("pageNum", cri.getPageNum());
		rttr.addFlashAttribute("amount", cri.getAmount());
		rttr.addFlashAttribute("type", cri.getType());
		rttr.addFlashAttribute("keyword", cri.getKeyword());
		
	    return "redirect:/board/list";
	}

}
