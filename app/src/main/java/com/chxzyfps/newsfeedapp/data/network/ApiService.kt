package com.chxzyfps.newsfeedapp.data.network

import androidx.lifecycle.LiveData
import com.chxzyfps.newsfeedapp.domain.ApiRespondItem
import com.chxzyfps.newsfeedapp.domain.ArticleItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    suspend fun getArticleList(
        @Query("q") query: String = "Apple",
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 20,
//        @Query("from") from: String = "2023-04-01",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = "749ca4249182428d92618d68e2424664"
    ) : ApiRespondItem
}

