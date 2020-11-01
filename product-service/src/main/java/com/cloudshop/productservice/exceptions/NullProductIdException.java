package com.cloudshop.productservice.exceptions;

public class NullProductIdException extends RuntimeException {
    public NullProductIdException() {
        super();
    }

    public NullProductIdException(String message) {
        super(message);
    }

    public NullProductIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullProductIdException(Throwable cause) {
        super(cause);
    }

}
