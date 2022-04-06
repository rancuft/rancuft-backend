package com.dsm.rancuft.controller

import com.dsm.rancuft.dto.TokenResponseDto
import com.dsm.rancuft.dto.UserCreateRequestDto
import com.dsm.rancuft.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {

    @PostMapping("/user")
    fun login(@RequestBody dto: UserCreateRequestDto) : TokenResponseDto{
        return userService.login(dto)
    }

}