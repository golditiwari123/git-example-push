package com.webapp.responce;

public class CustomResponse<T> {
  String message;
  T data;
public CustomResponse(String message, T data) {
	super();
	this.message = message;
	this.data = data;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}
  
  
  
}
