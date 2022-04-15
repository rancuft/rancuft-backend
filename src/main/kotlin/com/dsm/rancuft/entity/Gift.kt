package com.dsm.rancuft.entity

import com.dsm.rancuft.dto.Image
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
    val like: List<Like>,
    @Id
    val id : Int
    )