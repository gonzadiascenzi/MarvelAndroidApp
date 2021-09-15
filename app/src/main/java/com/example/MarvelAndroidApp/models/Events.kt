package com.example.MarvelAndroidApp.models.characters

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)