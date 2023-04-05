package com.chxzyfps.newsfeedapp.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chxzyfps.newsfeedapp.R
import com.chxzyfps.newsfeedapp.databinding.FragmentNewsListBinding
import com.chxzyfps.newsfeedapp.databinding.ItemArticleBinding
import com.chxzyfps.newsfeedapp.domain.ArticleItem

class ArticleListAdapter(private val context: Context) :
    ListAdapter<ArticleItem, ArticleListAdapter.ArticleItemViewHolder>(ArticleItemDiffCallback()) {


    var onArticleClickListener: OnArticleClickListener? = null

    class ArticleItemViewHolder(
        val binding: ItemArticleBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleItemViewHolder {
        val binding = ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ArticleItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleItemViewHolder, position: Int) {
        val currentItem = getItem(position)
        with(holder.binding) {
            Glide.with(context).load(currentItem.urlToImage).into(ivArticleImg)
            tvArticleTitle.text = currentItem.title
            tvArticleAuthor.text = currentItem.author
            root.setOnClickListener {
                onArticleClickListener?.onArticleClick(currentItem)
            }
        }
    }

    interface OnArticleClickListener {
        fun onArticleClick(articleItem: ArticleItem)
    }
}