package com.neoquest.model.response;

public class Response<T> {
    private boolean isSuccess = false;
    private String message = "Произошла ошибка";
    private String exceptionMessage;
    private T data = null;

    public Response(Exception exception) {
        this.exceptionMessage = exception.getMessage();
        this.isSuccess = false;
    }

    public Response(T data) {
        this.data = data;
        this.isSuccess = true;
        this.message = null;
    }

    public Response(String message, Exception exception) {
        this.message = message;
        this.exceptionMessage = exception.getMessage();
        this.isSuccess = false;
    }

    public Response(boolean isSuccess) {
        this.isSuccess = isSuccess;
        this.message = null;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getException() {
        return exceptionMessage;
    }

    public void setException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
