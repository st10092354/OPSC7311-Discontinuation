package com.example.projects

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

data class TimesheetEntry(
    val date: String = "",
    val startTime: String = "",
    val endTime: String = "",
    val description: String = "",
    val category: String = ""
)

class Timesheet : AppCompatActivity() {

    private val REQUEST_IMAGE_CAPTURE = 1

    private lateinit var editTextDate: EditText
    private lateinit var editTextStartTime: EditText
    private lateinit var editTextEndTime: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var spinnerCategory: Spinner
    private lateinit var buttonSubmit: Button

    private lateinit var imageView: ImageView
    private lateinit var buttonAddPhoto: Button

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timesheet)

        imageView = findViewById(R.id.newImage)
        buttonAddPhoto = findViewById(R.id.buttonAddPhoto)

        buttonAddPhoto.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Error: " + e.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

        db = FirebaseFirestore.getInstance()

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    if (drawerLayout.isDrawerOpen(navigationView)) {
                        drawerLayout.closeDrawer(navigationView)
                    }
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_categories -> {
                    val intent = Intent(this, AddCategoryActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_timesheet -> {
                    val intent = Intent(this, Timesheet::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_logout -> {
                    FirebaseAuth.getInstance().signOut()
                    val intent = Intent(this, Login::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_share -> {
                    Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_search -> {
                    Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_tools -> {
                    Toast.makeText(this, "Clicked Tools", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        editTextDate = findViewById(R.id.editTextDate)
        editTextStartTime = findViewById(R.id.editTextStartTime)
        editTextEndTime = findViewById(R.id.editTextEndTime)
        editTextDescription = findViewById(R.id.editTextDescription)
        spinnerCategory = findViewById(R.id.spinnerCategory)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            saveTimesheetEntry()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

    private fun saveTimesheetEntry() {
        val date = editTextDate.text.toString().trim()
        val startTime = editTextStartTime.text.toString().trim()
        val endTime = editTextEndTime.text.toString().trim()
        val description = editTextDescription.text.toString().trim()
        val category = spinnerCategory.selectedItem.toString()

        if (date.isEmpty() || startTime.isEmpty() || endTime.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return
        }

        val entry = TimesheetEntry(date, startTime, endTime, description, category)

        db.collection("timesheet_entries")
            .add(entry)
            .addOnSuccessListener {
                Toast.makeText(this, "Timesheet entry saved successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error saving timesheet entry", Toast.LENGTH_SHORT).show()
            }
    }
}



