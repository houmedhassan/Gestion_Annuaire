package com.application.business;

public class DaoException extends Exception {
	/**
	 * @param message
	 * 
	 * this class return a precise error message
	 */
	DaoException(String message){
		super(message);
	}
}
