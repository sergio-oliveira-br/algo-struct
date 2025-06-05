package com.github.sergiooliveirabr.algostruct.exceptions;

public class InvalidIndexException extends IndexOutOfBoundsException {

    public InvalidIndexException() {
        super("Invalid index");
    }

    public InvalidIndexException(String message) {
        super(message);
    }
}
