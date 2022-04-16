package com.dsm.rancuft.controller

import com.dsm.rancuft.service.GiftService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class GiftController(private val giftService: GiftService) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/gift")
    fun giftGave(@RequestPart("gift") files:MultipartFile,
                @RequestParam("comment") comment: String) {
        giftService.giftSave(comment, files)
    }
}