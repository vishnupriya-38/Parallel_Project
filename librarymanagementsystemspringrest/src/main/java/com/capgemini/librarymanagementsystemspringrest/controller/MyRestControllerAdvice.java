package com.capgemini.librarymanagementsystemspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.librarymanagementsystemspringrest.dto.LmsResponse;
import com.capgemini.librarymanagementsystemspringrest.exception.LMSException;

@RestControllerAdvice
public class MyRestControllerAdvice {

	@ExceptionHandler
	public LmsResponse myExceptionHandler(LMSException lmsException) {
		LmsResponse response = new LmsResponse();
		response.setError(true);
		response.setMessage(lmsException.getMessage());
		return response;
	}
}
