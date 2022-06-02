package com.dsm.rancuft.repository

import com.dsm.rancuft.entity.Gift
import com.dsm.rancuft.entity.User
import org.springframework.data.repository.CrudRepository

interface GiftRepository : CrudRepository<Gift, Int> {
    fun findAllByUser(user:User) : ArrayList<Gift>
}