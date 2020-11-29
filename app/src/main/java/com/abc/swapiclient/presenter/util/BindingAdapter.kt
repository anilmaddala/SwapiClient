package com.abc.swapiclient.presenter.util

import android.view.View
import android.view.View.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abc.swapiclient.R
import com.abc.swapiclient.domain.models.Person
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) VISIBLE else GONE
}

@BindingAdapter("visible")
fun View.setVisible(show: Boolean) {
    visibility = if (show) VISIBLE else INVISIBLE
}

@BindingAdapter("searchResults", "onSearchResultClick")
fun searchResults(view: RecyclerView, personList: List<Person>?, onSearchResultClick: (String) -> Unit) {
    view.adapter = SearchResultAdapter(onSearchResultClick)
    val adapter = view.adapter as SearchResultAdapter
    if (personList.isNullOrEmpty()) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
        adapter.submit(personList)
    }
}

/**
 *  Binding adapter for expandable list of URLs
 */
@BindingAdapter("listDataChild","onURLClick")
fun expandableAdapter(
    view: NoScrollExListView,
    listDataChild: HashMap<String, List<String>>,
    onURLClick: (String) -> Unit
) {
    view.setAdapter(ExpandableListAdapter(listDataChild, onURLClick))
}

/**
 * Binding adapter for loading images from URL
 */
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Glide.with(view.context)
        .load(imageUrl).apply(RequestOptions())
        .placeholder(R.drawable.placeholder)
        .into(view)
}