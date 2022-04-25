package com.dsm.rancuft.repository

import com.dsm.rancuft.entity.Song
import org.springframework.data.repository.CrudRepository

interface SongRepository : CrudRepository<Song, Int>{
}