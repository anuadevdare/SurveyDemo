package com.digital.survey.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * CustomizedResponseEntityExceptionHandler handles exceptions of throughout a
 * whole application by using @ControllerAdvice annotations
 * 
 */
@ControllerAdvice
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LogManager.getLogger(CustomizedResponseExceptionHandler.class);

	/**
	 * return the customize Exception response for any exception
	 * 
	 * @return object of Exception response class and internal server error as a
	 *         status
	 */

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		LOGGER.error("Http status is {} and Error is {}.", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * return the exception is thrown when argument annotated with @Valid failed
	 * validation:
	 * 
	 * @return object of Exception response class with the proper massage and
	 *         BAD_REQUEST as a status
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getDefaultMessage());
		}
		LOGGER.error("Http status is {} and Error is {}.", HttpStatus.BAD_REQUEST, errors.toString());
		return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
	}

}