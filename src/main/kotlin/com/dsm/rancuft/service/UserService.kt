package com.dsm.rancuft.service

import com.dsm.rancuft.dto.TokenResponseDto
import com.dsm.rancuft.dto.UserCreateRequestDto
import com.dsm.rancuft.entity.User
import com.dsm.rancuft.global.exception.rs.AlreadyNameException
import com.dsm.rancuft.global.jwt.JwtUtil
import com.dsm.rancuft.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepository: UserRepository, private val jwtUtil: JwtUtil){
    fun login(dto: UserCreateRequestDto): TokenResponseDto{
        val user = userRepository.findByNameAndPassword(dto.name, dto.password)?:userCreate(dto)
        return jwtUtil.createToken(user.name, user.id)
    }

    private fun userCreate(dto:UserCreateRequestDto) :User{
        if(userRepository.existsByName(dto.name)) {
            throw AlreadyNameException()
        }
        return userRepository.save(
            User(dto.name, dto.password) // 패스워드암호화
        )
    }

}