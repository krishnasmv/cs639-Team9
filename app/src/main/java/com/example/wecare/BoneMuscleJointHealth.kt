package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.content.Intent

import android.widget.Toast
import androidx.cardview.widget.CardView

class BoneMuscleJointHealth : AppCompatActivity() {
    private lateinit var binding: GeneralSymptoms
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_bone_muscle_joint_health);
//        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
//        val username = sharedPreferences.getString("username","").toString();
//        Toast.makeText(applicationContext,"welcome "+username, Toast.LENGTH_SHORT).show();

        val bonecard: CardView = findViewById(R.id.bone)
        bonecard.setOnClickListener {
            startActivity(Intent(this, BoneHealth::class.java))
        }

        val musclecard: CardView = findViewById(R.id.muscle)
            musclecard.setOnClickListener {
            startActivity(Intent(this, MuscleHealth::class.java))
        }

        val jointcard: CardView = findViewById(R.id.joint)
            jointcard.setOnClickListener {
            startActivity(Intent(this, JointHealth::class.java))
        }

    }
}