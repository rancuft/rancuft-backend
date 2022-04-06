package com.dsm.rancuft.global.exception

enum class ExceptionCode(val code:String, val message:String) {
    AlreadyExitName("404", "이름이 같은 유저가 이미 존재합니다."),
    IDontKnowThisError("400", "알 수 없는 오류입니다.")
}