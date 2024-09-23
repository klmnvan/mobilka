package com.example.ljubivaya_43p.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val email: String,
    val phone: String,
    val role: String,
    val name: String,
)
