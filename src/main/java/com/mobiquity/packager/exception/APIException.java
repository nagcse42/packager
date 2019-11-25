package com.mobiquity.packager.exception;

/**
 * 
 * @author Nagarjuna Paritala
 *
 */
public class APIException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public APIException(String _message) {
        super(_message);
    }

    public APIException(String _message, Throwable _cause) {
        super(_message, _cause);
    }
}
