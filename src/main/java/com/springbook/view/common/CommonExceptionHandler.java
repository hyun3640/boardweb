package com.springbook.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.springbook.view")
public class CommonExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(Exception e) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/common/arithmeticError.jsp");
		return mav;
	}
	
}