package io.spring201.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import io.spring201.controller.PropertyTaxController;

/**
 * @author M1046129
 *
 */
@ControllerAdvice
public class GobalExceptionHandler extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static final Logger LOGGER = Logger.getLogger(PropertyTaxController.class);

	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request, Exception ex) {
		LOGGER.info("SQLException Occured:: URL=" + request.getRequestURL());
		ModelAndView model = new ModelAndView();
		model.addObject("errors", ex.getMessage() + request.getRequestURL());
		model.setViewName("errors");
		return model;
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(HttpServletRequest request, Exception ex) {
		LOGGER.error("IOException Occured:: URL=" + request.getRequestURL());
		ModelAndView model = new ModelAndView();
		model.addObject("errors", ex.getMessage() + request.getRequestURL());
		model.setViewName("errors");
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception ex) {
		LOGGER.info("Exception Occured:: URL=" + request.getRequestURL());
		ModelAndView model = new ModelAndView();
		model.addObject("errors", ex.getMessage());
		model.setViewName("errors");
		return model;
	}
}
