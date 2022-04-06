package com.dsm.rancuft.entity

import lombok.Getter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Getter
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    val name: String,
    val password: String)