package com.miraclestudio.livesol.exception;

import com.miraclestudio.livesol.constant.ErrorCode;
import lombok.Getter;

@Getter
public class ServiceLogicException extends RuntimeException {

    private final ErrorCode errorCode;

    public ServiceLogicException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ServiceLogicException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
