package com.dsm.rancuft.service

import com.dsm.rancuft.entity.Gift
import com.dsm.rancuft.entity.User
import com.dsm.rancuft.repository.GiftRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class GiftService(private val giftRepository: GiftRepository, private val s3ImageService: S3ImageService) {
    fun giftSave(comment:String, gift:MultipartFile, user: User) {

        val image = s3ImageService.uploadFile(gift)

        giftRepository.save(
            Gift(image, comment,user)
        )
    }
}