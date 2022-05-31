package com.dsm.rancuft.entity

import javax.persistence.*

@Entity
@Table
class Gift (
    @Embedded
    val image: Image,
    val comment: String,
    @ManyToOne(fetch = FetchType.LAZY)
    val user: User,
    @OneToMany
    val heart: List<Heart>?=null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int?=null
    )