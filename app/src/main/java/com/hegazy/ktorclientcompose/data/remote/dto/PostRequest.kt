package com.hegazy.ktorclientcompose.data.remote.dto

import kotlinx.serialization.SerialInfo
import kotlinx.serialization.Serializable


@Serializable
data class PostRequest(
    val userId: Int,
    val title: String,
    val body: String,
)
