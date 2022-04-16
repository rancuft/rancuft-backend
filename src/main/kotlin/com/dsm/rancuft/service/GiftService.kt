package com.dsm.rancuft.service

import com.dsm.rancuft.repository.GiftRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class GiftService(private val giftRepository: GiftRepository) {
    fun giftSave(comment:String, gift:MultipartFile) {

    }
}