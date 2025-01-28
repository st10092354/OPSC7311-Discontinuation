package com.example.projects

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class HoursByCategoryActivity : AppCompatActivity() {
    private lateinit var startDatePicker: DatePicker
    private lateinit var endDatePicker: DatePicker
    private lateinit var loadHoursButton: Button
    private lateinit var hoursListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hours_by_category)

        startDatePicker = findViewById(R.id.startDatePicker)
        endDatePicker = findViewById(R.id.endDatePicker)
        loadHoursButton = findViewById(R.id.loadHoursButton)
        hoursListView = findViewById(R.id.hoursListView)

        loadHoursButton.setOnClickListener {
            val startDate = getDateFromDatePicker(startDatePicker)
            val endDate = getDateFromDatePicker(endDatePicker)

            // Load hours by category from the database
            val hours = loadHoursByCategory(startDate, endDate)

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, hours)
            hoursListView.adapter = adapter
        }
    }

    private fun getDateFromDatePicker(datePicker: DatePicker): Date {
        val day = datePicker.dayOfMonth
        val month = datePicker.month
        val year = datePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)

        return calendar.time
    }

    private fun loadHoursByCategory(startDate: Date, endDate: Date): List<String> {
        // Retrieve hours by category from the database based on the date range
        // ...

        // For demonstration purposes, return a mock list
        return listOf("Category 1: 10 hours", "Category 2: 5 hours", "Category 3: 8 hours")
    }
}
