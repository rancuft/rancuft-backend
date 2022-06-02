package com.dsm.rancuft.service

import com.dsm.rancuft.dto.GiftResponseDto
import com.dsm.rancuft.dto.MyGiftListsResponseDto
import com.dsm.rancuft.entity.User
import com.dsm.rancuft.repository.GiftRepository
import org.springframework.stereotype.Service

@Service
class GiftListService (private val giftRepository: GiftRepository){
    fun myGiftList(user: User):MyGiftListsResponseDto {
        val gifts:ArrayList<GiftResponseDto> =
            giftRepository.findAllByUser(user)
                .map { gift ->  GiftResponseDto(gift.id!!,gift.image.url,gift.comment)} as ArrayList<GiftResponseDto>

        return MyGiftListsResponseDto(user.name, gifts)
    }
}