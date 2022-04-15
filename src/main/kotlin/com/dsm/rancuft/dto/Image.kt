package com.dsm.rancuft.dto

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Image (
    @Column
    val name: String,
    val url: String)