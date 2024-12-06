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
        arrayOf("Doctor Name: Ajit Saste", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No: 9898989898", "600"),
        arrayOf("Doctor Name: Prasad Pawar", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No: 7898989898", "900"),
        arrayOf("Doctor Name: Swapnil Kale", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No: 8898989898", "300"),
        arrayOf("Doctor Name: Deepak Deshmukh", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No: 9898000000", "700"),
        arrayOf("Doctor Name: Ashok Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No: 7798989898", "800")
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
            startActivity(Intent(this, Cardiovascularhealth::class.java))
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