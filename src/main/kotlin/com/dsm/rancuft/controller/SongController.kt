package com.dsm.rancuft.controller

import com.dsm.rancuft.dto.SongRequestDto
import com.dsm.rancuft.service.SongService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class SongController(private val songService: SongService) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/song")
    fun recommendSongCreate(@RequestBody dto: SongRequestDto) {
        songService.createRecommendSong(dto)
    }
}