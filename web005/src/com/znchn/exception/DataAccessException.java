package com.znchn.exception;

public class DataAccessException extends Exception{

	public DataAccessException() {
		super();
	} 
	
	public DataAccessException(String msg) {
		super(msg);
	}
	
	public DataAccessException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public DataAccessException(Throwable throwable) {
		super(throwable);
	}
}
