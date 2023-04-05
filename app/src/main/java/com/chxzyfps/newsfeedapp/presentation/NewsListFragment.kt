package com.chxzyfps.newsfeedapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chxzyfps.newsfeedapp.R
import com.chxzyfps.newsfeedapp.data.network.ApiFactory
import com.chxzyfps.newsfeedapp.databinding.FragmentNewsListBinding
import com.chxzyfps.newsfeedapp.domain.ArticleItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class NewsListFragment : Fragment() {

    private var _binding: FragmentNewsListBinding? = null
    private val binding: FragmentNewsListBinding
        get() = _binding ?: throw RuntimeException("FragmentNewsListBinding == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var adapter: ArticleListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupAdapter()
//        setupItemClickListener()
    }

    private fun setupAdapter() {
        viewModel.articleList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        adapter = ArticleListAdapter(requireContext())
        binding.rvArticleList.adapter = adapter
    }

//    private fun setupItemClickListener() {
//        adapter.onArticleClickListener = object : ArticleListAdapter.OnArticleClickListener {
//            override fun onArticleClick(articleItem: ArticleItem) {
//                articleItem.urlToImage?.let {
//                    ArticleFragment.newInstance(
//                        articleItem.content,
//                        it,
//                        articleItem.title
//                    )
//                }?.let {
//                    requireActivity().supportFragmentManager
//                        .beginTransaction()
//                        .replace(
//                            R.id.main_container,
//                            it
//                        )
//                        .addToBackStack(null)
//                        .commit()
//                }
//            }
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}