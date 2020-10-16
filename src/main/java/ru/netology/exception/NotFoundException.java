package ru.netology.exception;

public class NotFoundException extends RuntimeException {
    public void throwException() {
        throw new NotFoundException();
    }
}