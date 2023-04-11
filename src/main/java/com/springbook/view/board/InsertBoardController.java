package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//스프링 컨테이너는 @Controller가 선언된 객체를 자동으로 Controller 객체로 인식된다.
@Controller // @Component를 상속한 @Controller는 @Controller가 붙은 클래스 객체를 메모리에 생성하는 기능을 제공한다. 하지만 단순히 객체를 생성하는 것에 그치치 않고, DispatcherServlet이 인식하는 Controller 객체로 만들어 준다
public class InsertBoardController {

	
//	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response)
	 // 스프링에서는 @RequestMapping을 이용하여 HandlerMapping 설정을 대체한다.
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo,BoardDAO boardDAO) {	//사용자가 입력하는 정보가 많거나 변경되는 상황에서는 컨트롤러 클래스가 변경되어야 하므로 불편하다. 매개변수로 받은 VO객체를 이용하면 된다.
		System.out.println("글 등록 처리");	// 스프링 컨테이너가 insertBoard() 메소드를 실행할 때 사용자가 입력한 값들을 BoardVO 객체에 셋팅해서 넘겨준다.
										// 결과적으로 사용자 입력 정보 추출과 VO 객체 생성, 그리고 값 설정을 모두 컨테이너가 자동으로 처리
										// DAO 객체 역시 매개변수로 선언하면 스프링 컨테이너가 객체를 생성하여 전달해준다.
		// 1. 사용자 입력 정보 추출
		// request.setCharacterEncoding("EUC-KR");
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");

		// 2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);

		// 클라이언트가 글 등록을 요청하면 스프링 컨테이너는 InsertBoardController 객체의 
		// insertBoard() 메소드를 호출한다.
		// 이 때 변수에 해당하는 BoardVO 객체를 생성하고
		// 사용자가 입력한 파라미터(title, writer, content) 값들을 추출하여 BoardVO 객체에 저장함
		// 이 때 BoardVO 클래스의 Setter 메소들이 호출
		// insertBoard() 메소드 호출시 사용자 입력값들이 설정되 BoardVO 객체가 인자로 전달된다.
		// 여기서 중요한 점은 Form 태그 안의 파라미터 이름과 객체의 Setter이름이 반드시 일치해야 한다.
		// 각 파라미터 이름에 해당하는 setTitle(), setWriter(), setContent() 메소드가 잇어야 Setter 인젝션에 의해 자동으로 사용자 입력값이 저장된다 
		
//		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";

		/*
		 * ModelAndView mav = new ModelAndView();
		 * mav.setViewName("redirect:getBoardList.do"); return mav;
		 */
	}

}
