package com.sy.review.domain.movie.exception;

import com.sy.review.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class InvalidMovieException extends BusinessException {
    public InvalidMovieException() {
        super(HttpStatus.BAD_REQUEST, "유효 하지 않는 영화입니다.");
    }
}
