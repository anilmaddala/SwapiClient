package com.abc.swapiclient.presenter.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.abc.swapiclient.databinding.SearchResultItemBinding
import com.abc.swapiclient.domain.models.Person

/**
 * Adapter for Search results
 */
class SearchResultAdapter(val onSearchResultClick: (String) -> Unit) : RecyclerView.Adapter<SearchResultViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Person>(){
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer<Person>(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        return SearchResultViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        holder.binding.root.setOnClickListener {
            onSearchResultClick(differ.currentList[position].id.toString())
        }
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submit(personList: List<Person>) {
        differ.submitList(personList.toMutableList())
    }

}

/**
 * View Holder for Search result
 */
class SearchResultViewHolder(val binding: SearchResultItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(e: Person) {
        binding.person  = e
    }

    companion object {
        fun from(parent: ViewGroup): SearchResultViewHolder {
            return SearchResultViewHolder(SearchResultItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }
}