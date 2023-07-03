package com.Geekster.Hospital.Management.System.Services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDoctorAvailableException extends RuntimeException {
    public NoDoctorAvailableException(String message) {
        super(message);
    }
}
