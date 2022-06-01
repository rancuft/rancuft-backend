package com.dsm.rancuft.service

import com.dsm.rancuft.entity.Gift
import com.dsm.rancuft.entity.Heart
import com.dsm.rancuft.entity.User
import com.dsm.rancuft.global.exception.rs.GiftNotFoundException
import com.dsm.rancuft.repository.GiftRepository
import com.dsm.rancuft.repository.HeartRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HeartService(private val heartRepository: HeartRepository, private val giftRepository: GiftRepository) {
    @Transactional
    fun heartSave(user: User, id:Int) {
        val gift : Gift = giftRepository.findByIdOrNull(id)?:throw GiftNotFoundException()
        if(heartRepository.existsByGiftAndUser(gift, user)) {
            heartRepository.deleteByGiftAndUser(gift, user)
        } else {
            heartRepository.save(
                Heart(gift, user)
            )
        }
    }
}