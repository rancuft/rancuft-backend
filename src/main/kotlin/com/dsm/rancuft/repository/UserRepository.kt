package com.dsm.rancuft.repository

import com.dsm.rancuft.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int>{
    fun existsByName(name:String) : Boolean
}