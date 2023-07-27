package com.example.customizealertbox

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner

class SubmitFeedback : AppCompatActivity() {
    lateinit var thanksDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_feedback)
        val submitbtn = findViewById<Button>(R.id.button4)
        submitbtn.setOnClickListener {
            thanksDialog.show()
        }
        thanksDialog = Dialog(this)
        thanksDialog.setContentView(R.layout.thanks_custom_dialog) //accessing the dialog box that we have created
        thanksDialog.window?.setBackgroundDrawable(getDrawable(R.drawable.alertbox_bg))

        //on clcking on submit button thanks dialog shoudl popup
        var buttonOk = thanksDialog.findViewById<Button>(R.id.buttonok)

        buttonOk.setOnClickListener {  //ok clicked on thanks popup it must dismiss
            thanksDialog.dismiss()
            val mainpageintent = Intent(applicationContext, MainActivity::class.java)
            startActivity(mainpageintent)
        }
    }
}