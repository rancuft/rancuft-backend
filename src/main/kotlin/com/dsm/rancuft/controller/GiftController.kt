package com.dsm.rancuft.controller

import com.dsm.rancuft.entity.User
import com.dsm.rancuft.service.GiftService
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class GiftController(private val giftService: GiftService) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/gift")
    fun giftGave(@AuthenticationPrincipal user: User,
                 @RequestPart("gift") files:MultipartFile,
                 @RequestParam("comment") comment: String) {
        giftService.giftSave(comment, files, user)
    }
}