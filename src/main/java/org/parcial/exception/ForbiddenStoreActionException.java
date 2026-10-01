package org.parcial.exception;

public class ForbiddenStoreActionException extends RuntimeException {
    public ForbiddenStoreActionException(String message) {
        super(message);
    }
}
