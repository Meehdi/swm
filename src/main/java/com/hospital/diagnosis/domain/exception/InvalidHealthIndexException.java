package com.hospital.diagnosis.domain.exception;

public class InvalidHealthIndexException extends RuntimeException {

    public InvalidHealthIndexException(String message) {
        super("Health index must be positive");
    }
}