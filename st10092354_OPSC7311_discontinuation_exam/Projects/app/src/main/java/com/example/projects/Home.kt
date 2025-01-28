package com.example.projects

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class Home : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar

    private lateinit var buttonSettings: Button
    private lateinit var buttonTimesheetList: Button
    private lateinit var buttonHoursByCategory: Button
    private lateinit var buttonGraph: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        buttonSettings = findViewById(R.id.buttonSettings)
        buttonTimesheetList = findViewById(R.id.buttonTimesheetList)
        buttonHoursByCategory = findViewById(R.id.buttonHoursByCategory)
        buttonGraph = findViewById(R.id.buttonGraph)

        buttonSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        buttonTimesheetList.setOnClickListener {
            startActivity(Intent(this, TimesheetListActivity::class.java))
        }

        buttonHoursByCategory.setOnClickListener {
            startActivity(Intent(this, HoursByCategoryActivity::class.java))
        }

        buttonGraph.setOnClickListener {
            startActivity(Intent(this, GraphActivity::class.java))
        }

        // Initialize ActionBarDrawerToggle and add it to the DrawerLayout
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar , R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Enable the "up" button in the action bar to open/close the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set item selected listener for NavigationView
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle item selection here
            when (menuItem.itemId) {
                R.id.nav_home -> {
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
                    val firebaseAuth = FirebaseAuth.getInstance()
                    // Sign out the user
                    firebaseAuth.signOut()
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
                    Toast.makeText(applicationContext, "Clicked Tools", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

class Categories {

}

