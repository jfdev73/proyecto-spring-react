package com.miranda.usersapp.config;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Código de estado 400
    @ResponseBody
    public Map<String, String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, String> errorMap = new HashMap<>();
        String uniqueUser = "uk_m2dvbwfge291euvmk6vkkocao";
        String uniqueEmail = "uk_kfsp0s1tflm1cwlj8idhqsad0";
        // Extraer el mensaje de error específico de la excepción
        String errorMessage = ex.getMessage();


        // Verificar si el mensaje de error contiene información sobre una restricción única
        if (errorMessage.contains(uniqueUser)) {
            System.out.println("El usuario ya existe");
            errorMap.put("username", "El usuario ya existe!");
        } else if (errorMessage.contains(uniqueEmail)) {
            errorMap.put("email", "El email ya existe!");
        }

        return errorMap;
    }
}
