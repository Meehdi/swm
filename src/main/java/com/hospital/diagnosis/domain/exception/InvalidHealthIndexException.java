package com.hospital.diagnosis.domain.exception;

public class InvalidHealthIndexException extends RuntimeException {

    public InvalidHealthIndexException() {
        super("Health index must be positive");
    }
}