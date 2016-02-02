package com.blinch.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by markuskopf on 29/01/16.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GroupNotFoundException extends RuntimeException{

    public GroupNotFoundException(final String message) {
        super(message);
    }

}
