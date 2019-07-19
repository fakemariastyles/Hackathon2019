package com.mmb.hackathon2019.application.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.mmb.hackathon2019.R
import com.mmb.hackathon2019.application.ui.amount.AmountFragment
import com.mmb.hackathon2019.application.ui.home.HomeFragment
import com.mmb.hackathon2019.data.repository.HackathonRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, HomeFragment())
            .addToBackStack(null)
            .commit()

    }
}
