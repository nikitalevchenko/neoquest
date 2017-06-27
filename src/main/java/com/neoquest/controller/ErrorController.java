package com.neoquest.controller;

import com.neoquest.model.response.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response processException(Exception e) {
        Logger.getLogger(ErrorController.class.getName()).log(Level.SEVERE, null, e);
        if (e.getMessage().contains("already exists")) {
            return new Response("Ваше устройство уже участовавло в голосовании", e);
        }
        return new Response(e);
    }
}
