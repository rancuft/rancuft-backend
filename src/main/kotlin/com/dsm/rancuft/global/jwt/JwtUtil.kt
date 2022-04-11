package com.dsm.rancuft.global.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.dsm.rancuft.dto.TokenResponseDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {
    @Value("\${auth.secret}")
    lateinit var secretKey:String

    fun createToken(user: String, id: Int?):TokenResponseDto{
        return TokenResponseDto(
            JWT.create()
                .withClaim("name",user)
                .withClaim("id", id)
                .withIssuedAt(Date())
                .withExpiresAt(Date(System.currentTimeMillis()+30*10000*6000))
                .sign(Algorithm.HMAC256(secretKey))
        )
    }
}