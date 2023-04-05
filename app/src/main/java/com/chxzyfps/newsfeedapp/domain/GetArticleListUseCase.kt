package com.chxzyfps.newsfeedapp.domain

class GetArticleListUseCase(private val repository: NewsAppRepository) {

    suspend operator fun invoke() = repository.getArticlesList()

}