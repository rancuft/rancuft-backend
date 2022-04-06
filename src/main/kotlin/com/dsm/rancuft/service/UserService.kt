package com.dsm.rancuft.service

import com.dsm.rancuft.dto.TokenResponseDto
import com.dsm.rancuft.dto.UserCreateRequestDto
import com.dsm.rancuft.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepository: UserRepository){
    fun login(dto: UserCreateRequestDto): TokenResponseDto{
        // 닉네임 중복 검사
        if(userRepository.existsByName(dto.name)) {

        }

        // 만약 유저를 찾을 수 있다면
        return TokenResponseDto("");
    }
}