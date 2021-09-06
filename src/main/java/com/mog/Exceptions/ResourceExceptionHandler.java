package com.mog.Exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandError> ObjectNotFound(ObjectNotFoundException e,HttpServletRequest request){
		
		HttpStatus status=HttpStatus.NOT_FOUND;	
		StandError err=new StandError(System.currentTimeMillis(),status.value(),"Não Encontrado",request.getRequestURI(),e.getMessage());
		return ResponseEntity.status(status).body(err);
			
	}
}
