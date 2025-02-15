package com.sy.review.api.controller;

public record ErrorResponse(
        int errorCode,
        String message
) {}
