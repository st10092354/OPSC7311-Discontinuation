package com.example.projects

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    private lateinit var minDailyGoalEditText: EditText
    private lateinit var maxDailyGoalEditText: EditText
    private lateinit var saveGoalsButton: Button

    private val userSettings = UserSettings()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        minDailyGoalEditText = findViewById(R.id.minDailyGoal)
        maxDailyGoalEditText = findViewById(R.id.maxDailyGoal)
        saveGoalsButton = findViewById(R.id.saveGoalsButton)

        saveGoalsButton.setOnClickListener {
            val minGoal = minDailyGoalEditText.text.toString().toIntOrNull() ?: 0
            val maxGoal = maxDailyGoalEditText.text.toString().toIntOrNull() ?: 0

            userSettings.minDailyGoal = minGoal
            userSettings.maxDailyGoal = maxGoal

            // Save userSettings to shared preferences or a database
            saveUserSettings(userSettings)
        }
    }

    private fun saveUserSettings(settings: UserSettings) {
        // Implement your saving logic here (e.g., SharedPreferences, Room, etc.)
    }
}
