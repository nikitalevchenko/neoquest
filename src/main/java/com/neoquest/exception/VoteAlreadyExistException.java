package com.neoquest.exception;

public class VoteAlreadyExistException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Vote already Exist";
    }
}