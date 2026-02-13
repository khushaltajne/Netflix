package com.netflix.utility;

import java.util.List;

public class ResponseMessage {
	 String status;
	 Integer statusCode;
	 String message;
	 Object obj;
	 List<Object> listObj;
	public ResponseMessage(String status, Integer statusCode, String message) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
	}
	public ResponseMessage(String status, Integer statusCode, String message, Object obj) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.obj = obj;
	}
	public ResponseMessage(String status, Integer statusCode, String message, List<Object> listObj) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.listObj = listObj;
	}
	
	
}
