package com.java.planning.book.service.exception;

public class GeneralException {

    public static class UnHandledException extends RuntimeException {
        public UnHandledException(String message) {
            super(message);
        }
    }
}
