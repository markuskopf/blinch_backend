package com.blinch.server.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by markuskopf on 13/01/16.
 */
@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
public class NotYetImplementedException extends RuntimeException {

    public NotYetImplementedException(final String message) {
        super(message);
    }

}