package com.gft.helpdesk.exceptions;

import java.io.Serial;

public class ApiException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -1754598341175111993L;

	private String message;

	public ApiException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
