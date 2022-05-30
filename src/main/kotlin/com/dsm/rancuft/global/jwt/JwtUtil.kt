package com.dsm.rancuft.global.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.dsm.rancuft.dto.TokenResponseDto
import com.dsm.rancuft.entity.User
import com.dsm.rancuft.repository.UserRepository
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException
import java.nio.charset.StandardCharsets
import java.util.*

@Component
class JwtUtil (private val userRepository: UserRepository){

    @Value("\${auth.secret}")
    lateinit var secretKey:String

    fun createToken(user: String, id: Int):TokenResponseDto{
        return TokenResponseDto(
            JWT.create()
                .withClaim("name",user)
                .withClaim("id", id)
                .withIssuedAt(Date())
                .withExpiresAt(Date(System.currentTimeMillis()+30*10000*6000))
                .sign(Algorithm.HMAC256(secretKey))
        )
    }

    fun validateToken(token: String) : Boolean {
        try {
            getClaims(token)
            return true
        } catch (e: Exception) {
            throw IllegalArgumentException("token error")
        }
    }

    fun getAuthentication(token: String) : Authentication{
        return UsernamePasswordAuthenticationToken(getUser(token), null, null)
    }

    fun getUser(token: String): User {
        return userRepository.findByIdOrNull(getUserId(token))
            ?: throw IllegalArgumentException("not found user")
    }

    fun getUserId(token: String) : Int {
        return getClaims(token)["id"] as Int
    }

    fun getClaims(token: String) : Claims {
        val key = Keys.hmacShaKeyFor(secretKey.toByteArray(StandardCharsets.UTF_8))
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token).body
    }
}