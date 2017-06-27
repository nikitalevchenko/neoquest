package com.neoquest.exception;

public class ReportsListIsEmptyException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Reports list is empty";
    }
}
