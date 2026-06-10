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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView()