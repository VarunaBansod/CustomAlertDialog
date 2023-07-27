package com.example.customizealertbox

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    //creat a variable of type dialog
    lateinit var openDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mybutton = findViewById<Button>(R.id.button3) //this is in activity_main

        openDialog = Dialog(this)
        openDialog.setContentView(R.layout.custom_design) //accessing the dialog box that we have created
        //to popup alert box with some style and background
        openDialog.window?.setBackgroundDrawable(getDrawable(R.drawable.alertbox_bg))

        //creating variable for the custom_design.xml
        //syntax: dialog_type_variable_name.findViewById<Button>(R.id.button2)
        var buttonyes = openDialog.findViewById<Button>(R.id.button2)
        var buttonfeedback = openDialog.findViewById<Button>(R.id.button)

        buttonyes.setOnClickListener {
            //on clicking on yes
            openDialog.dismiss() //to dismiss or close custom dialog box
        }
        buttonfeedback.setOnClickListener {
            //on clicking on share your thoughts
            val intentFeedback = Intent(applicationContext, SubmitFeedback::class.java)
            startActivity(intentFeedback)
        }

        mybutton.setOnClickListener {
            //on main page when someone click on give feedback
            openDialog.show()
        }

        val spinnerId = findViewById<Spinner>(R.id.spinner)

        val sessionAttended = arrayOf("less that 5", "less that 10", "less that 20", "less that 50", "more than 50","more that 100", "All sessions attended" )
        val arrayAdp = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, sessionAttended)
        spinnerId.adapter = arrayAdp

    }
}