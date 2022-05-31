package com.dsm.rancuft.global.exception.rs

import com.dsm.rancuft.global.exception.CommonException
import com.dsm.rancuft.global.exception.ExceptionCode
import org.springframework.http.HttpStatus

class GiftNotFoundException : CommonException(
    code = ExceptionCode.GiftNotFound,
    status = HttpStatus.NOT_FOUND
)