package com.example.imad_pacticum_version_20

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imad_pacticum_version_20.ui.theme.IMAD_Pacticum_Version_20Theme
import java.lang.reflect.Array

class MainActivity : ComponentActivity() {

    private lateinit var splashLayout: LinearLayout

    private lateinit var mainLayout: ScrollView

    private lateinit var detailsLayout: ScrollView

    private lateinit var txtTotal: TextView

    private lateinit var txtDetails: TextView

    private lateinit var editGear: EditText

    private lateinit var editQuantity: EditText

    private lateinit var editComments: EditText

    private lateinit var spinnerCategory: Spinner

    private val category = arrayOf(
        "Shelter", "Food", "Safety",
        "Clothing", "Medkit", "Communication", "Entertainment"
    )

    private val gear = Array(7){""}

    private val quantity = IntArray(7)

    private val comments = Array(7){""}

    private val total = arrayOf(1,2,3,4,5,6,7)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.act_main)

        splashLayout = findViewById(R.id.splashLayout)
        mainLayout = findViewById(R.id.mainLayout)
        detailsLayout = findViewById(R.id.detailsLayout)

        txtTotal = findViewById(R.id.txtTotal)
        txtDetails = findViewById(R.id.txtDetails)

        editGear = findViewById(R.id.editGear)
        editQuantity = findViewById(R.id.editQuantity)
        editComments = findViewById(R.id.editComments)

        spinnerCategory = findViewById(R.id.spinnerCategory)


        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            category
        )

        spinnerCategory.adapter = adapter

        //Buttons

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnExitSplash = findViewById<Button>(R.id.btnExitSplash)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnTotal = findViewById<Button>(R.id.btnTotal)
        val btnDetails = findViewById<Button>(R.id.btnDetails)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val btnBack = findViewById<Button>(R.id.btnBack)

        // Splash Screen Navigation
        btnStart.setOnClickListener {
            splashLayout.visibility = View.GONE
            mainLayout.visibility = View.VISIBLE
        }

        btnExitSplash.setOnClickListener {
            finish()
        }

        // Save Data
        btnSave.setOnClickListener {

            if (editGear.text.isEmpty() ||
                editQuantity.text.isEmpty() ||
                editComments.text.isEmpty())
            {
                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_LONG
                ).show()

            }else {

                val index = spinnerCategory.selectedItemPosition

                gear[index] = editGear.text.toString()
                quantity[index] = editQuantity.text.toString().toInt()
                comments[index] = editComments.text.toString()


                Toast.makeText(
                    this,
                    "Data Saved Successfully",
                    Toast.LENGTH_LONG
                ).show()


                editGear.text.clear()
                editQuantity.text.clear()
                editComments.text.clear()
            }
        }

        //Calculate Total with while loop
         btnTotal.setOnClickListener {


            val numbers = txtTotal.text.toString().toInt()
             var i = 0
             var result = ""

             while (i<=numbers) {
                 result +="$i"
                 i++
             }

         }

    // View Details
    btnDetails.setOnClickListener {

        var display = ""

        for (i in category.indices) {

            display += "${category[i]}\n"
            display += "Gear: ${gear[i]}\n"
            display += "Quantity: ${quantity[i]}\n"
            display += "Comments: ${comments[i]}\n\n"
        }

        txtDetails.text = display

        mainLayout.visibility = View.GONE
        detailsLayout.visibility = View.VISIBLE
    }

    // Back Button
    btnBack.setOnClickListener {
        detailsLayout.visibility = View.GONE
        mainLayout.visibility = View.VISIBLE
    }

    // Clear Data
    btnClear.setOnClickListener {

        for (i in gear.indices) {
            gear[i] = ""
            quantity[i] = 0
            comments[i] = ""
        }

        txtTotal.text = "Average Weekly Temperature"

        Toast.makeText(
            this,
            "Data Cleared",
            Toast.LENGTH_LONG
        ).show()

    }

    // Exit App
    btnExit.setOnClickListener {
        finish()
    }
}
}
