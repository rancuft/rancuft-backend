package com.dsm.rancuft.global.exception

import org.springframework.http.HttpStatus

open class CommonException (
    val code: ExceptionCode,
    val status: HttpStatus,
) : RuntimeException(code.message)