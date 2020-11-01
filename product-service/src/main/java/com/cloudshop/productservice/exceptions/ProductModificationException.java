package com.cloudshop.productservice.exceptions;

public class ProductModificationException extends RuntimeException{
    public ProductModificationException() {
        super();
    }

    public ProductModificationException(String message) {
        super(message);
    }

    public ProductModificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductModificationException(Throwable cause) {
        super(cause);
    }
}
