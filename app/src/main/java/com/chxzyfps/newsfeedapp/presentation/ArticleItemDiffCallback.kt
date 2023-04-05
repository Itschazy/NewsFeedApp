package com.chxzyfps.newsfeedapp.presentation

import androidx.recyclerview.widget.DiffUtil
import com.chxzyfps.newsfeedapp.domain.ArticleItem

class ArticleItemDiffCallback: DiffUtil.ItemCallback<ArticleItem>() {
    override fun areItemsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean {
        return oldItem == newItem
    }

}