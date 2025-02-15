package com.sy.review.domain.drama.exception;

import com.sy.review.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class InvalidDramaException extends BusinessException {
    public InvalidDramaException() {
        super(HttpStatus.BAD_REQUEST, "유효 하지 않는 드라마입니다.");
    }
}
