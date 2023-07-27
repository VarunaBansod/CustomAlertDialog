# CustomAlertDialog
## To make Splash Screen add the following
1. Add `android.enableJetifier=true` in gradle.properties  and sync the project <br>
2. add this on splashScreen.kt `Handler().postDelayed({
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }, 3000)`
## To make custom dialog box 
1. enter this above onCreate method `lateinit var openDialog: Dialog` //openDialog is variable name
2.  custom_design is an xml file which will be shown as alert dialog box <br>
   `openDialog = Dialog(this)` <br>
   `openDialog.setContentView(R.layout.custom_design)` //write this below "setContentView" to access the custom dialog box
    - make sure to keep `android:layout_height="wrap_content"` of custom_design.xml
3. `openDialog.window?.setBackgroundDrawable(getDrawable(R.drawable.alertbox_bg))` //if you want to add some style to custom_dialog make a drawable resource file of   type "shape" and add design in it.
4. create variable for custom_design.xml in .kt file → syntax: dialog_type_variable_name.findViewById<Button>(R.id.button2) <br>
`var buttonyes = openDialog.findViewById<Button>(R.id.button2)` <br>
`var buttonfeedback = openDialog.findViewById<Button>(R.id.button)`
5. When user click on yes dialog box should dismiss `buttonyes.setOnClickListener { openDialog.dismiss() //to dismiss or close custom dialog box }`
6. to show/popup dialog box `mybutton.setOnClickListener { openDialog.show() //on main page when someone click on give feedback }` <br>

## To make dropdown
1. make `<Spinner .... />` in xml
2. make varialbe in .kt file `val spinnerId = findViewById<Spinner>(R.id.spinner)`
3. make array containg all the option `val sessionAttended = arrayOf("less that 5", "less that 10", "less that 20", "less that 50", "more than 50","more that 100", "All sessions attended" )`
4. add adapter and call it `val arrayAdp = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, sessionAttended)` `spinnerId.adapter = arrayAdp`
