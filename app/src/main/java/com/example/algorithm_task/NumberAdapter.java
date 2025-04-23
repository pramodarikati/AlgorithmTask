package com.example.algorithm_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Set;


public class NumberAdapter extends BaseAdapter {

    private final Context context;
    private final int[] numbers;
    private final Set<Integer> highlightedNumbers;

    public NumberAdapter(Context context, int[] numbers, Set<Integer> highlightedNumbers) {
        this.context = context;
        this.numbers = numbers;
        this.highlightedNumbers = highlightedNumbers;
    }

    @Override
    public int getCount() {
        return numbers.length;
    }

    @Override
    public Object getItem(int position) {
        return numbers[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.number_text);
        int number = numbers[position];
        textView.setText(String.valueOf(number));

        if (highlightedNumbers.contains(number)) {
            textView.setBackgroundColor(context.getResources().getColor(android.R.color.holo_blue_light));
        } else {
            textView.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        }

        return convertView;
    }
}
