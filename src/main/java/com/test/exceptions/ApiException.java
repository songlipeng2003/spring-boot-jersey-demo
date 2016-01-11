package com.test.exceptions;

public class ApiException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 298158809431137696L;

	@SuppressWarnings("unused")
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}