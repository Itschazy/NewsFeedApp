package com.chxzyfps.newsfeedapp.domain

data class ApiRespondItem(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleItem>
)
