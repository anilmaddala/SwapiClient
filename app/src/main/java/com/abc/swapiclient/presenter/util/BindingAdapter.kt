package com.abc.swapiclient.presenter.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.abc.swapiclient.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 *  Binding adapter for expandable list of URLs
 */
@BindingAdapter("listDataHeader", "listDataChild","onURLClick")
fun expandableAdapter(
    view: NoScrollExListView,
    listDataHeader: List<String>,
    listDataChild: HashMap<String, List<String>>,
    onURLClick: (String) -> Unit
) {
    view.setAdapter(ExpandableListAdapter(listDataHeader, listDataChild, onURLClick))
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