package com.example.projects

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projects.databinding.ActivityCategoriesBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class CategoryManagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriesBinding
    private lateinit var db: CategoriesDatabaseHelper
    private lateinit var CategoriesAdapter: CategoriesAdapter

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        db = CategoriesDatabaseHelper(this)
        CategoriesAdapter = CategoriesAdapter(db.getAllCategories(),this)

        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.categoryRecyclerView.adapter = CategoriesAdapter

        binding.addButton.setOnClickListener{
            val intent = Intent(this, AddCategoryActivity::class.java)
            startActivity(intent)
        }


        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        // Set item selected listener for NavigationView
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle item selection here
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    if (drawerLayout.isDrawerOpen(navigationView)) {
                        drawerLayout.closeDrawer(navigationView)
                    }
                }


                R.id.nav_categories -> {
                    val intent = Intent(this, Categories::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_home -> {
                    val intent = Intent(this, Home::class.java)
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

        // Initialize ActionBarDrawerToggle and add it to the DrawerLayout
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar , R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Enable the "up" button in the action bar to open/close the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        }

    override fun onResume() {
        super.onResume()
        CategoriesAdapter.refreshData(db.getAllCategories())
    }

}

