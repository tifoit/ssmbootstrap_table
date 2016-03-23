package cn.com.ttblog.ssmbootstrap_table.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import cn.com.ttblog.ssmbootstrap_table.exception.CustomGenericException;

/**
 * @ExceptionHandler只能在一个controller上添加,标记所有controller需要使用@ControllerAdvice来全局处理异常 
 * @author netbuffer
 */
@ControllerAdvice
public class GlobalExceptionController {
	Logger log=LoggerFactory.getLogger(getClass());
	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {
		log.info("发生错误1:{}",ToStringBuilder.reflectionToString(ex));
		ModelAndView model = new ModelAndView("error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		log.info("发生错误2:{}",ToStringBuilder.reflectionToString(ex));
		ModelAndView model = new ModelAndView("error");
		model.addObject("errMsg",ex.getMessage());
		return model;
	}

}