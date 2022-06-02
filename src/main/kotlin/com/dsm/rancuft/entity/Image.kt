package com.dsm.rancuft.entity

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Image (
    @Column
    val fileName: String,
    val url: String)