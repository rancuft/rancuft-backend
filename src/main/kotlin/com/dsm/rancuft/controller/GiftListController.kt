package com.dsm.rancuft.controller

import com.dsm.rancuft.dto.MyGiftListsResponseDto
import com.dsm.rancuft.entity.User
import com.dsm.rancuft.service.GiftListService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GiftListController(private val giftService: GiftListService) {

    @GetMapping("/gift-list")
    fun myGiftListGet(@AuthenticationPrincipal user: User) :MyGiftListsResponseDto{
        return giftService.myGiftList(user)
    }
}