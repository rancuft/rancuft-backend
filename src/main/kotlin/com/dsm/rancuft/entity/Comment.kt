package com.dsm.rancuft.entity

import lombok.Getter
import javax.persistence.*

@Table
@Entity
@Getter
class Comment (
    val comment: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int?=null,)