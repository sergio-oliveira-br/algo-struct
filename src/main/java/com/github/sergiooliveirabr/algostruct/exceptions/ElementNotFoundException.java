package com.github.sergiooliveirabr.algostruct.exceptions;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException() {
        super("Element not found");
    }

    public ElementNotFoundException(String message) {
        super(message);
    }

    public ElementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
