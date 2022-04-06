package com.dsm.rancuft.global.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(CommonException::class)
    fun commonExceptionHandler(e: CommonException) =
        ResponseEntity(
            CommonExceptionRs(
                code=e.code,
                message = e.message?: "알 수 없는 오류",
            ),
            e.status,
        )
}