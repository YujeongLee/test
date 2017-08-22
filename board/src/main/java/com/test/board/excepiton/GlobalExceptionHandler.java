package com.test.board.excepiton;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {

	//@ExceptionHandler(Exception.class)
	public String errorHandler(Model model, Exception ex) {
		model.addAttribute("msg", "에러 발생");
		model.addAttribute("ex", ex);
		return "/exception/error";
	}
}














