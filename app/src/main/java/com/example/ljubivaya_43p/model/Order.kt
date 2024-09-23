package com.example.ljubivaya_43p.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val id: Int,
    @SerialName("user_id")
    val userId: String,
    @SerialName("id_product")
    val idProduct: Int,
)
