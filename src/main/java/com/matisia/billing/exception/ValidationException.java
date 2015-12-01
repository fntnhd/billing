package com.matisia.billing.exception;

/**
 * ValidationException is thrown whenever a constraint is violated.
 */
public class ValidationException extends Exception {

    public ValidationException(String reason) {
        super(reason);
    }

}
