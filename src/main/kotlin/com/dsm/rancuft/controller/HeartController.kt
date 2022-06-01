package com.dsm.rancuft.controller

import com.dsm.rancuft.entity.User
import com.dsm.rancuft.service.HeartService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HeartController(private val heartService: HeartService) {

    @PostMapping("/gift/{id}/like")
    fun heartSave(@AuthenticationPrincipal user: User, @PathVariable id:Int) {
        heartService.heartSave(user, id)
    }
}