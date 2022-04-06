package com.dsm.rancuft.global.exception

import org.springframework.http.HttpStatus

open class CommonException (
    code: String,
    val status: HttpStatus,
) : RuntimeException(code)