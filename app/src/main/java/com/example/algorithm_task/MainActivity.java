package com.example.algorithm_task;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private NumberAdapter numberAdapter;
    private final int[] numbers = new int[100];
    private final Set<Integer> highlightedNumbers = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 100; i++) {
            numbers[i] = i + 1;
        }

        gridView = findViewById(R.id.number_grid);
        numberAdapter = new NumberAdapter(this, numbers, highlightedNumbers);
        gridView.setAdapter(numberAdapter);

        Spinner ruleSpinner = findViewById(R.id.rule_spinner);

        ArrayList<String> rules = new ArrayList<>();
        rules.add("Select Numbers");
        rules.add("Odd Numbers");
        rules.add("Even Numbers");
        rules.add("Prime Numbers");
        rules.add("Fibonacci Numbers");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                rules
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ruleSpinner.setAdapter(spinnerAdapter);

        ruleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    highlightedNumbers.clear();
                } else {
                    updateHighlightedNumbers(position - 1);
                }
                numberAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void updateHighlightedNumbers(int ruleIndex) {
        highlightedNumbers.clear();

        switch (ruleIndex) {
            case 0:
                for (int number : numbers) {
                    if (NumberUtils.isOdd(number)) {
                        highlightedNumbers.add(number);
                    }
                }
                break;

            case 1:
                for (int number : numbers) {
                    if (NumberUtils.isEven(number)) {
                        highlightedNumbers.add(number);
                    }
                }
                break;

            case 2:
                for (int number : numbers) {
                    if (NumberUtils.isPrime(number)) {
                        highlightedNumbers.add(number);
                    }
                }
                break;

            case 3:
                highlightedNumbers.addAll(NumberUtils.getFibonacciNumbersUpTo(100));
                break;
        }
    }
}
