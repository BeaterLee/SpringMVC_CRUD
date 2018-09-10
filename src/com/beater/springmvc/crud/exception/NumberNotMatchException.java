package com.beater.springmvc.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus可以注解在异常类或方法上
//注解在异常类时，发生该类的异常时，会返回设置的HttpStatus和reason(异常信息)
//注解在方法上，执行被注解的方法时，会返回设置的HttpStatus和reason(异常信息)
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="数字不匹配")
public class NumberNotMatchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
