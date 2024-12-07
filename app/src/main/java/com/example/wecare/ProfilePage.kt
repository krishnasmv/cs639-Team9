package com.example.wecare

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wecare.databinding.ActivityProfilePageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class ProfilePage : AppCompatActivity() {
    private lateinit var user: FirebaseAuth
    private lateinit var binding: ActivityProfilePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilePageBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_page)
        user = FirebaseAuth.getInstance()
        val exit: LinearLayout = findViewById(R.id.logout)
        exit.setOnClickListener {
            user.signOut()
            startActivity(Intent(this, SigninActivity::class.java))

        }

//        binding.logout.setOnClickListener({
//            user.signOut()
//            startActivity(Intent(this, SigninActivity::class.java))
//        })
    }
}