package com.example.wecare

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class CustomExpandableListAdapter(
    private val context: Context,
    private val listGroupTitles: List<String>,
    private val listChildData: HashMap<String, List<Pair<String, String>>>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int = listGroupTitles.size

    override fun getChildrenCount(groupPosition: Int): Int =
        listChildData[listGroupTitles[groupPosition]]!!.size

    override fun getGroup(groupPosition: Int): Any = listGroupTitles[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int): Any =
        listChildData[listGroupTitles[groupPosition]]!![childPosition]

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun hasStableIds(): Boolean = false

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val title = getGroup(groupPosition) as String
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.group_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.groupTitle)
        textView.text = title
        return view
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val child = getChild(groupPosition, childPosition) as Pair<String, String>
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.child_item, parent, false)

        val titleTextView = view.findViewById<TextView>(R.id.childTitle)
        val detailsTextView = view.findViewById<TextView>(R.id.childDetails)

        titleTextView.text = child.first
        detailsTextView.text = child.second

        return view
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true
}
