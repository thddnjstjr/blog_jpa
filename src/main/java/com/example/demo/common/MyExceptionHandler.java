package com.example.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.common.errors.Exception400;
import com.example.demo.common.errors.Exception401;
import com.example.demo.common.errors.Exception403;
import com.example.demo.common.errors.Exception404;
import com.example.demo.common.errors.Exception500;

// RuntimeException 터지면 해당 파일로 오류가 모인다.
@RestControllerAdvice // C.A --> 뷰 에러페이지. R.C.A 데이터 반환 (에러)
public class MyExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
	
	@ExceptionHandler(Exception400.class)
	public ResponseEntity<?> ex400(Exception400 e) {
		ApiUtil<?> apiUtil = new ApiUtil<>(400, e.getMessage());
		return new ResponseEntity<>(apiUtil, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception401.class)
	public ResponseEntity<?> ex401(Exception401 e) {
		ApiUtil<?> apiUtil = new ApiUtil<>(401, e.getMessage());
		return new ResponseEntity<>(apiUtil, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(Exception403.class)
	public ResponseEntity<?> ex403(Exception403 e) {
		ApiUtil<?> apiUtil = new ApiUtil<>(403, e.getMessage());
		return new ResponseEntity<>(apiUtil, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Exception404.class)
	public ResponseEntity<?> ex404(Exception404 e) {
		ApiUtil<?> apiUtil = new ApiUtil<>(404, e.getMessage());
		return new ResponseEntity<>(apiUtil, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception500.class)
	public ResponseEntity<?> ex500(Exception500 e) {
		ApiUtil<?> apiUtil = new ApiUtil<>(500, e.getMessage());
		return new ResponseEntity<>(apiUtil, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
