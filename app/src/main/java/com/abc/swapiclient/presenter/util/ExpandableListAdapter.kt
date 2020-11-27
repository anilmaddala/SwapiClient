package com.abc.swapiclient.presenter.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.abc.swapiclient.R

class ExpandableListAdapter internal constructor(
    private val context: Context,
    private val titleList: List<String>,
    var data: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {

    var dataList = data

    fun getAdvancedOptionsState(): HashMap<String, List<String>> {
        return dataList
    }


    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return dataList[titleList[listPosition]]!![expandedListPosition]
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getChildView(
        listPosition: Int,
        expandedListPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val childText = getChild(listPosition, expandedListPosition) as String
        var convertView = convertView
        if (convertView == null) {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.expandable_list_item, null)
        }
        val expandedListTextView = convertView!!.findViewById<TextView>(R.id.expandedListItem)
        expandedListTextView.text = childText

        return convertView
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return dataList[titleList[listPosition]]!!.size
    }

    override fun getGroup(listPosition: Int): Any {
        return titleList[listPosition]
    }

    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getGroupView(
        listPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val listTitle = getGroup(listPosition) as String
        if (convertView == null) {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.expandable_list_group, null)
        }
        val listTitleTextView = convertView!!.findViewById<TextView>(R.id.listTitle)
        listTitleTextView.text = listTitle
        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }
}
