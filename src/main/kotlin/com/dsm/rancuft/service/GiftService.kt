package com.dsm.rancuft.service

import com.dsm.rancuft.dto.GiftResponseDto
import com.dsm.rancuft.entity.Comment
import com.dsm.rancuft.entity.Gift
import com.dsm.rancuft.entity.User
import com.dsm.rancuft.global.exception.rs.GiftNotFoundException
import com.dsm.rancuft.repository.CommentRepository
import com.dsm.rancuft.repository.GiftRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import kotlin.random.Random

@Service
class GiftService(private val giftRepository: GiftRepository,
                  private val s3ImageService: S3ImageService,
                private val commentRepository: CommentRepository){
    fun giftSave(comment:String, gift:MultipartFile, user: User) :String{
        val image = s3ImageService.uploadFile(gift)

        giftRepository.save(
            Gift(image, comment, user)
        )

        return image.url
    }

    fun giftGet() : GiftResponseDto{
        val gift :Gift= giftRepository.findByIdOrNull(
            randomNum(giftRepository.count()))
            ?: throw GiftNotFoundException()

        var comment: String = gift.comment

        if (comment.isEmpty()) {
            comment = commentRepository.findByIdOrNull(
                randomNum(commentRepository.count())
            )?.comment ?: "💛⭐"
        }

        return GiftResponseDto(gift.id!!,gift.image.url, comment)
    }

    private fun randomNum(max: Long) : Int {
        return Random.nextInt(1, max.toInt()+1)
    }
}