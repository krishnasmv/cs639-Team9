package com.example.wecare

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wecare.databinding.ActivitySigninBinding
import android.content.SharedPreferences as SharedPreferences

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_home);
        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username","").toString();
        Toast.makeText(applicationContext,"welcome "+username, Toast.LENGTH_SHORT).show();

        val exit: CardView = findViewById(R.id.generalsymptoms)
        exit.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this, GeneralSymptoms::class.java))
        }

        val skinandhair: CardView = findViewById(R.id.skinandhair)
        skinandhair.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this, SkinandHair::class.java))
        }

    }
}
