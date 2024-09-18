package com.example.ljubivaya_43p.model

import io.ktor.http.ContentType
import kotlinx.serialization.Serializable
import org.w3c.dom.Text

@Serializable
data class products(
    val id: Int,
    val name: String,
    val description: Text,
    val image: String,
    val price:Int?
)

