package com.dsm.rancuft.service

import com.dsm.rancuft.dto.SongRequestDto
import com.dsm.rancuft.entity.Song
import com.dsm.rancuft.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SongService(private val songRepository: SongRepository) {
    fun createRecommendSong(dto:SongRequestDto) {
        songRepository.save(
            Song(
                dto.singer,
                dto.title,
                dto.who
            )
        )
    }
}