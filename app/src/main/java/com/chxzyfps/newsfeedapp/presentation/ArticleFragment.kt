package com.chxzyfps.newsfeedapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.chxzyfps.newsfeedapp.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private var _binding: FragmentArticleBinding? = null
    private val binding: FragmentArticleBinding
        get() = _binding ?: throw RuntimeException("FragmentArticleBinding == null")

    private var articleTitle = ""
    private var articleContent = ""
    private var articleImg = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        getArgs()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvArticleTitle.text = articleTitle
            tvArticleContent.text = articleContent
            Glide.with(requireActivity()).load(articleImg).into(ivArticleImg)
        }

    }

    private fun getArgs() {
        with(requireArguments()) {
            getString(ARTICLE_CONTENT)?.let {
                articleContent = it
            }
            getString(ARTICLE_TITLE)?.let {
                articleTitle = it
            }
            getString(ARTICLE_IMAGE)?.let {
                articleImg = it
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        private const val ARTICLE_CONTENT = "article_content"
        private const val ARTICLE_IMAGE = "article_image"
        private const val ARTICLE_TITLE = "article_title"

        fun newInstance(articleContent: String, articleImg: String, articleTitle: String) =
            ArticleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARTICLE_CONTENT, articleContent)
                    putString(ARTICLE_IMAGE, articleImg)
                    putString(ARTICLE_TITLE, articleTitle)
                }
            }
    }
}