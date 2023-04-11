package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 //어떤 Controller 객체가 검색되더라도 같은 코드로 실행하려면 모든 Controller의 최상위 인터페이스가 필요하다.

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController  {

	//public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 처리");

//		// 1. 사용자 입력 정보 추출
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//		// 2. DB 연동 처리
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//
//		// 3. 화면 네비게이션
//		ModelAndView mav = new ModelAndView();
//		if (user != null) {
//			mav.setViewName("redirect:getBoardList.do");
//		}else {
//			mav.setViewName("redirect:login.jsp");
//		}
//		return mav;
		if(userDAO.getUser(vo)!=null) return "getBoardList.do";
		else return "login.jsp";
	}

}
