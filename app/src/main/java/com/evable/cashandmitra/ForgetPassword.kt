package com.evable.cashandmitra

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class ForgetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        // declaring the variable
        var phoneNumber=findViewById<EditText>(R.id.yourNumber)
        var reqPassword=findViewById<Button>(R.id.reqPassword)

        //getting user input
            var yourPhone = phoneNumber.text.toString().trim()

            //reqPassword.isEnabled = false


        phoneNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               // reqPassword.isEnabled = mobileValidate(phoneNumber.text.toString())
            }

            override fun afterTextChanged(s: Editable?) {



            }
        })

        reqPassword.setOnClickListener {
            if (mobileValidate(phoneNumber.text.toString()))
            {
//                //progress bar
                val CDT: CountDownTimer
                var i = 5
                val progressDialog = ProgressDialog(this)
                progressDialog.setTitle("Sending Otp")
                progressDialog.show()
                progressDialog.setCancelable(false)
                CDT = object : CountDownTimer(5000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        progressDialog.setMessage("Please wait.." + i.toString() + " sec")
                        i--
                    }

                    override fun onFinish() {
                        progressDialog.dismiss()
                        //Your Code ...
                    }
                }.start()
                //end Progress bar

                intent = Intent(this, OtpVerify::class.java)
                startActivity(intent)
            }
            else
            {
                phoneNumber.error = "Enter a valid Mobile"

            }

        }
    }


    private fun mobileValidate(text: String?): Boolean {
        var p:Pattern=Pattern.compile("[6-9][0-9]{9}")
        var m:Matcher=p.matcher(text)
        return m.matches()

    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        finishAffinity()
//    }

}