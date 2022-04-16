package com.dsm.rancuft.repository

import com.dsm.rancuft.entity.Gift
import org.springframework.data.repository.CrudRepository

interface GiftRepository : CrudRepository<Gift, Int> {
}