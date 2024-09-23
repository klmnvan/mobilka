package com.example.ljubivaya_43p.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val image: String?
)

