package com.sy.review.domain.drama.exception;

import com.sy.review.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DramaNotFoundException extends BusinessException {

    public DramaNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "없는 드라마입니다. ID : %d".formatted(id));
    }
}
