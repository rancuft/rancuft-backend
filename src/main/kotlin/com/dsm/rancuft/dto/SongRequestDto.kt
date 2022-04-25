package com.dsm.rancuft.dto

data class SongRequestDto (
    val singer: String,
    val title: String,
    val who: String // 추천하고 싶은 사람
    )