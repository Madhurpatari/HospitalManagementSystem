package com.Geekster.Hospital.Management.System.Services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LocationNotSupportedException extends RuntimeException {
    public LocationNotSupportedException(String message) {
        super(message);
    }
}
