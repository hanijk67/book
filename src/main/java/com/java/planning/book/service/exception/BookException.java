package com.java.planning.book.service.exception;

public class BookException {

    public static class BookNotFoundException extends RuntimeException {
        public BookNotFoundException(String message) {
            super(message);
        }
    }
     public static class BookAlreadyExistException extends RuntimeException {
        public BookAlreadyExistException(String message) {
            super(message);
        }
    }


}
