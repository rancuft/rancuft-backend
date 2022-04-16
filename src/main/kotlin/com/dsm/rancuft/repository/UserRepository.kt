package com.dsm.rancuft.repository

import com.dsm.rancuft.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int>{
    fun existsByName(name:String) : Boolean
    fun findByNameAndPassword(name:String, password:String) : User?
}