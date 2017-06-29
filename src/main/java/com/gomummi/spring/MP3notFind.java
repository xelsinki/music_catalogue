package com.gomummi.spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class MP3notFind extends RuntimeException{

	public MP3notFind(Exception cause) {
		super(cause);
	}
}
	
	


