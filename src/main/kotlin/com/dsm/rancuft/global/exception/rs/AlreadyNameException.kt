package com.dsm.rancuft.global.exception.rs

import com.dsm.rancuft.global.exception.CommonException
import com.dsm.rancuft.global.exception.ExceptionCode
import org.springframework.http.HttpStatus

class AlreadyNameException:CommonException(
    code = ExceptionCode.AlreadyExitName,
    status = HttpStatus.BAD_REQUEST,
)