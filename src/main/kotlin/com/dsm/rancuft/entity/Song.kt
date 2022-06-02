package com.dsm.rancuft.entity

import javax.persistence.*


@Entity
@Table
class Song (
    val singer: String,
    val title: String,
    val who: String, // 추천하고 싶은 사람
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?=null,
)