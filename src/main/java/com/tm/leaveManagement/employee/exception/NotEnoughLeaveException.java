package com.tm.leaveManagement.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotEnoughLeaveException extends Exception{

    public NotEnoughLeaveException(String message) {
        super(message);
    }
}
