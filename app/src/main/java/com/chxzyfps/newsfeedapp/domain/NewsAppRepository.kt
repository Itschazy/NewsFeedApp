package com.chxzyfps.newsfeedapp.domain

interface NewsAppRepository {

    suspend fun getArticlesList(): List<ArticleItem>

}