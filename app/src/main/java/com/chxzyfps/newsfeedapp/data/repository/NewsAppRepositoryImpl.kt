package com.chxzyfps.newsfeedapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.chxzyfps.newsfeedapp.data.Mapper
import com.chxzyfps.newsfeedapp.data.network.ApiFactory
import com.chxzyfps.newsfeedapp.domain.ApiRespondItem
import com.chxzyfps.newsfeedapp.domain.ArticleItem
import com.chxzyfps.newsfeedapp.domain.NewsAppRepository

class NewsAppRepositoryImpl: NewsAppRepository {

    private val mapper = Mapper()

    override suspend fun getArticlesList(): List<ArticleItem> {
        val apiRespond = ApiFactory.apiService.getArticleList()
        return mapper.mapApiRespondItemToEntity(apiRespond)
    }
}