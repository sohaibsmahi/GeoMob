package com.example.geomob.data

data class Data(
    val author_id: String,
    val created_at: String,
    val entities: Entities,
    val format: String,
    val id: String,
    val referenced_tweets: List<ReferencedTweet>,
    val text: String
)