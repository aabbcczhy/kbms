package com.fjnu.kbms.error;

public interface CommonError {
	
	int getErrorCode();
	
	String getErrorMessage();
	
	CommonError setErrorMessage(String msg);
	
}
