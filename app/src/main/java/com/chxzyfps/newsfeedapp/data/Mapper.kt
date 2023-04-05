package com.chxzyfps.newsfeedapp.data

import com.chxzyfps.newsfeedapp.domain.ApiRespondItem
import com.chxzyfps.newsfeedapp.domain.ArticleItem

class Mapper {

    fun mapApiRespondItemToEntity(apiRespondItem: ApiRespondItem): List<ArticleItem> {
        val result = mutableListOf<ArticleItem>()
        apiRespondItem.articles.forEach {
            if (it.urlToImage.isNullOrEmpty()) {
                it.urlToImage = "https://png.pngtree.com/background/20211217/original/pngtree-television-news-background-picture-image_1594889.jpg"
            }
            result.add(it)
        }
        return result
    }
}