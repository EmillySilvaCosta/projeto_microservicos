package com.gft.helpdesk.exceptions;

public class EntityNotFoundException extends ApiException {

	private static final long serialVersionUID = -2276980426085309785L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
