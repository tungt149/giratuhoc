package com.tuhocgira.common.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ResponseHandler {
	public static ResponseEntity<Object> getResponse(Object content, HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		map.put("content", content);
		map.put("errors", "");
		map.put("timestamp",DateUtils.toString( LocalDateTime.now()));
		map.put("status", status.value());
		return new ResponseEntity<Object>(map, status);
	}
	public static Object getResponse(BindingResult errors, HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		map.put("content", "");
		map.put("errors", ErrorUtils.getErrorMessages(errors));
		map.put("timestamp", DateUtils.toString( LocalDateTime.now()));
		map.put("status", status.value());
		return new ResponseEntity<Object>(map, status);
	}
	public static Object getResponse(HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		map.put("content", "");
		map.put("errors", "");
		map.put("timestamp", DateUtils.toString( LocalDateTime.now()));
		map.put("status", status.value());
		return new ResponseEntity<Object>(map, status);
	}
}
