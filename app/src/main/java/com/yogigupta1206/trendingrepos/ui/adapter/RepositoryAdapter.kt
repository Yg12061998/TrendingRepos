package com.yogigupta1206.trendingrepos.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yogigupta1206.trendingrepos.R
import com.yogigupta1206.trendingrepos.data.model.repos.Repos
import com.yogigupta1206.trendingrepos.databinding.RepoSingleRowBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.DataViewHolder>() {

    private var list = mutableListOf<Repos>()

    inner class DataViewHolder(var binding: RepoSingleRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(index: Int, repo: Repos) = binding.apply {
            data = repo
            executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataViewHolder = DataViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.repo_single_row, parent, false
        )
    )

    override fun onBindViewHolder(holder: RepositoryAdapter.DataViewHolder, position: Int) {
        holder.bind(position, list[position])
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: MutableList<Repos>){
        Log.d("testing", "$newList")
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}