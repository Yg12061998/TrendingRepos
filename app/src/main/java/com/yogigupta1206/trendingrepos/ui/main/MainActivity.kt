package com.yogigupta1206.trendingrepos.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogigupta1206.trendingrepos.databinding.ActivityMainBinding
import com.yogigupta1206.trendingrepos.ui.adapter.RepositoryAdapter
import com.yogigupta1206.trendingrepos.utils.hide
import com.yogigupta1206.trendingrepos.utils.show
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var reposAdapter: RepositoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setObservers()
        setAdapter()
        viewModel.init()

    }

    private fun setAdapter() {
        reposAdapter = RepositoryAdapter()
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mBinding.recyclerView.adapter = reposAdapter
    }

    private fun setObservers() {
        viewModel.uiState.observe(this) {
            when (it) {
                is MainViewModel.UiState.Loading -> {
                    mBinding.progress.show()
                }
                is MainViewModel.UiState.LoadingFinish -> {
                    mBinding.progress.hide()
                }
                is MainViewModel.UiState.ErrorState -> {
                    //TODO
                }
            }
        }

        viewModel.repos.observe(this) {
            reposAdapter?.submitList(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(com.yogigupta1206.trendingrepos.R.menu.menu, menu)
        val searchViewItem: MenuItem =
            menu.findItem(com.yogigupta1206.trendingrepos.R.id.app_bar_search)
        val searchView: SearchView = MenuItemCompat.getActionView(searchViewItem) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterData(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun filterData(text: String?) {
        val filteredList = viewModel.filter(text.toString())
        mBinding.recyclerView.layoutManager?.scrollToPosition(0)
        reposAdapter?.submitList(filteredList)
    }

}