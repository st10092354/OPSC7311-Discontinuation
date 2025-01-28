package com.example.projects

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class TimesheetListActivity : AppCompatActivity() {
    private lateinit var startDatePicker: DatePicker
    private lateinit var endDatePicker: DatePicker
    private lateinit var loadEntriesButton: Button
    private lateinit var timesheetListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timesheet_list)

        startDatePicker = findViewById(R.id.startDatePicker)
        endDatePicker = findViewById(R.id.endDatePicker)
        loadEntriesButton = findViewById(R.id.loadEntriesButton)
        timesheetListView = findViewById(R.id.timesheetListView)

        loadEntriesButton.setOnClickListener {
            val startDate = getDateFromDatePicker(startDatePicker)
            val endDate = getDateFromDatePicker(endDatePicker)

            // Load timesheet entries from the database
            val entries = loadTimesheetEntries(startDate, endDate)

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, entries)
            timesheetListView.adapter = adapter
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

    private fun loadTimesheetEntries(startDate: Date, endDate: Date): List<String> {
        // Retrieve entries from the database based on the date range
        // ...

        // For demonstration purposes, return a mock list
        return listOf("Entry 1", "Entry 2", "Entry 3")
    }
}
