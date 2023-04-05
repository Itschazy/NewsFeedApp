package com.chxzyfps.newsfeedapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chxzyfps.newsfeedapp.data.repository.NewsAppRepositoryImpl
import com.chxzyfps.newsfeedapp.domain.ArticleItem
import com.chxzyfps.newsfeedapp.domain.GetArticleListUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = NewsAppRepositoryImpl()

    private val getArticleListUseCase = GetArticleListUseCase(repository)

    private val _articleList = MutableLiveData<List<ArticleItem>>()
    val articleList: LiveData<List<ArticleItem>>
        get() = _articleList

    init {
        viewModelScope.launch {
            _articleList.value = getArticleListUseCase.invoke()
        }

    }

}