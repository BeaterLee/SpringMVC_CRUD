package com.beater.springmvc.crud.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//Controller升级版
@ControllerAdvice
public class HandleException {

	/**
	 * @ExceptionHandler注解的方法异常类可作为入参，Map不可作为入参，所以要在前台使用异常信息的话，需要使用ModelAndView作为返回值
	 * @ControllerAdvice可以注解为异常处理类，@Controller注解的类中找不到@ExceptionHandler注解的处理异常的方法话，则会到该注解的类中查找
	 * @ExceptionHandler有处理优先级，优先调用匹配度较高的异常处理方法
	 * 
	 */
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView exHandler(Exception ex) {
		System.out.println(ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}
}
