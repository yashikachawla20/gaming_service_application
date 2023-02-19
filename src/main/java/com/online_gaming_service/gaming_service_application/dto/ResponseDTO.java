package com.online_gaming_service.gaming_service_application.dto;

public class ResponseDTO<T> {
    public ResponseStatusCode statusCode;
    public T data;
    
    
	public ResponseStatusCode getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(ResponseStatusCode statusCode) {
		this.statusCode = statusCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}    
}
