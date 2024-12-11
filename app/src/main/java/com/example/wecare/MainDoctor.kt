package com.example.wecare

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainDoctor : AppCompatActivity() {
    private val doctorDetails = arrayOf(
        arrayOf("Doctor Name: Dr. James Anderson", "Hospital Address: New York City, NY", "Exp: 10yrs", "Mobile No: 2125551234", "150"),
    arrayOf("Doctor Name: Dr. Emily Carter", "Hospital Address: Los Angeles, CA", "Exp: 8yrs", "Mobile No: 3105552345", "200"),
    arrayOf("Doctor Name: Dr. John Smith", "Hospital Address: Chicago, IL", "Exp: 12yrs", "Mobile No: 7735553456", "180"),
    arrayOf("Doctor Name: Dr. Sarah Lee", "Hospital Address: Miami, FL", "Exp: 6yrs", "Mobile No: 3055554567", "250"),
    arrayOf("Doctor Name: Dr. Michael Johnson", "Hospital Address: Houston, TX", "Exp: 15yrs", "Mobile No: 7135555678", "300"),
    arrayOf("Doctor Name: Dr. Laura Davis", "Hospital Address: Boston, MA", "Exp: 9yrs", "Mobile No: 6175556789", "220"),
    arrayOf("Doctor Name: Dr. David Brown", "Hospital Address: San Francisco, CA", "Exp: 14yrs", "Mobile No: 4155557890", "280"),
    arrayOf("Doctor Name: Dr. Elizabeth White", "Hospital Address: Washington, D.C.", "Exp: 11yrs", "Mobile No: 2025558901", "210"),
    arrayOf("Doctor Name: Dr. William Green", "Hospital Address: Seattle, WA", "Exp: 7yrs", "Mobile No: 2065559012", "230"),
    arrayOf("Doctor Name: Dr. Jessica Clark", "Hospital Address: Phoenix, AZ", "Exp: 13yrs", "Mobile No: 6025550123", "260")
    )
    private lateinit var tv: TextView
    private lateinit var tvsec: TextView
    private lateinit var btn: Button
    var doctor_details: Array<Array<String>> = arrayOf()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_doctor)

        tv = findViewById(R.id.textViewTitle)
        tvsec = findViewById(R.id.textViewDD)
        btn = findViewById(R.id.button2)

        val title = intent.getStringExtra("title")
        Log.d("MainDoctor", "Received title: $title") // Log the title
        tv.text = title

        tvsec.text = "Available General Physicians"
        tv.text = "Consult Doctor"

        doctor_details = doctorDetails

//        if (title == "Family Physicians") {
//            doctor_details = doctorDetails
//        } else {
//            Log.d("MainDoctor", "No doctor details to display for title: $title")
//        }

        btn.setOnClickListener {
            startActivity(Intent(this, MainHomePage::class.java))
        }

        // Populate the ListView only if there are doctor details
        if (doctor_details.isNotEmpty()) {
            val list = ArrayList<HashMap<String, String>>()
            for (i in doctor_details.indices) {
                val item = HashMap<String, String>()
                item["line1"] = doctor_details[i][0]
                item["line2"] = doctor_details[i][1]
                item["line3"] = doctor_details[i][2]
                item["line4"] = doctor_details[i][3]
                item["line5"] = "Cons Fees: ${doctor_details[i][4]}/-"
                list.add(item)
            }

            val sa = SimpleAdapter(
                this,
                list,
                R.layout.multi_lines,
                arrayOf("line1", "line2", "line3", "line4", "line5"),
                intArrayOf(R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e)
            )

            val lst: ListView = findViewById(R.id.listView)
            lst.adapter = sa
        } else {
            Log.d("MainDoctor", "Doctor details are empty, nothing to display.")
        }
    }
}