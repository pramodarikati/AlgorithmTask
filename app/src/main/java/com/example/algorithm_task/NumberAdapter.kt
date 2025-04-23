package com.example.algorithm_task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NumberAdapter(
    private val context: Context,
    private val numbers: IntArray,
    private val highlightedNumbers: MutableSet<Int?>
) : BaseAdapter() {
    override fun getCount(): Int {
        return numbers.size
    }

    override fun getItem(position: Int): Any {
        return numbers[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        }

        val textView = convertView?.findViewById<TextView?>(R.id.number_text)
        val number = numbers[position]
        textView?.setText(number.toString())

        if (highlightedNumbers.contains(number)) {
            textView?.setBackgroundColor(
                context.getResources().getColor(android.R.color.holo_blue_light)
            )
        } else {
            textView?.setBackgroundColor(
                context.getResources().getColor(android.R.color.transparent)
            )
        }

        return convertView!!
    }
}