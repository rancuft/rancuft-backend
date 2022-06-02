package com.dsm.rancuft.entity

import lombok.Getter
import javax.persistence.*

@Table
@Entity
@Getter
class User (
    val name: String,
    val password: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?=null)