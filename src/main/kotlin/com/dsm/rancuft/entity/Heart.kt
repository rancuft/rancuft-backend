package com.dsm.rancuft.entity

import javax.persistence.*

@Entity
@Table
class Heart (
    @OneToOne(fetch = FetchType.LAZY)
    val gift: Gift,
    @OneToOne(fetch = FetchType.LAZY)
    val user: User,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?=null
    )