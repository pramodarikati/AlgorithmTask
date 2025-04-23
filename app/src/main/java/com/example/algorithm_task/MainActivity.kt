package com.example.algorithm_task

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var gridView: GridView? = null
    private var numberAdapter: NumberAdapter? = null
    private val numbers = IntArray(100)
    private val highlightedNumbers: MutableSet<Int?> = HashSet<Int?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..99) {
            numbers[i] = i + 1
        }

        gridView = findViewById<GridView?>(R.id.number_grid)
        numberAdapter = NumberAdapter(this, numbers, highlightedNumbers)
        gridView!!.setAdapter(numberAdapter)

        val ruleSpinner = findViewById<Spinner?>(R.id.rule_spinner)

        val rules = ArrayList<String?>()
        rules.add("Select Numbers")
        rules.add("Odd Numbers")
        rules.add("Even Numbers")
        rules.add("Prime Numbers")
        rules.add("Fibonacci Numbers")

        val spinnerAdapter = ArrayAdapter<String?>(
            this,
            android.R.layout.simple_spinner_item,
            rules
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ruleSpinner.setAdapter(spinnerAdapter)

        ruleSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {
                    highlightedNumbers.clear()
                } else {
                    updateHighlightedNumbers(position - 1)
                }
                numberAdapter!!.notifyDataSetChanged()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })
    }

    private fun updateHighlightedNumbers(ruleIndex: Int) {
        highlightedNumbers.clear()

        when (ruleIndex) {
            0 -> for (number in numbers) {
                if (NumberUtils.isOdd(number)) {
                    highlightedNumbers.add(number)
                }
            }

            1 -> for (number in numbers) {
                if (NumberUtils.isEven(number)) {
                    highlightedNumbers.add(number)
                }
            }

            2 -> for (number in numbers) {
                if (NumberUtils.isPrime(number)) {
                    highlightedNumbers.add(number)
                }
            }

            3 -> highlightedNumbers.addAll(NumberUtils.getFibonacciNumbersUpTo(100))
        }
    }
}