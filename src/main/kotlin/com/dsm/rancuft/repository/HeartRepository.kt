package com.dsm.rancuft.repository

import com.dsm.rancuft.entity.Gift
import com.dsm.rancuft.entity.Heart
import com.dsm.rancuft.entity.User
import org.springframework.data.repository.CrudRepository

interface HeartRepository:CrudRepository<Heart, Int> {
    fun existsByGiftAndUser(gift :Gift, user: User) : Boolean
    fun deleteByGiftAndUser(gift :Gift, user: User)
}