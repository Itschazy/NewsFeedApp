package com.chxzyfps.newsfeedapp.domain

data class ArticleItem(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    var urlToImage: String?,
    val publishedAt: String,
    val content: String
)
