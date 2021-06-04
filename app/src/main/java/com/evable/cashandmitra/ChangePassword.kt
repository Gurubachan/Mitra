package com.evable.cashandmitra

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern


class ChangePassword : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)


        var btn_Pass=findViewById<EditText>(R.id.newPassword)
        var btn_CPass=findViewById<EditText>(R.id.confirmPassword)
        var myBtn = findViewById<Button>(R.id.changePassword)

        var btn_Password = btn_Pass.text.toString().trim()
        var btn_ConfirmPass = btn_CPass.text.toString().trim()








            btn_Pass.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
            }
        })


         myBtn.setOnClickListener {
             if(passwordValidation())
             {
                 //progress bar
                 val CDT: CountDownTimer
                 var i = 5
                 val progressDialog = ProgressDialog(this)
                 progressDialog.setTitle("Password Generating")
                 progressDialog.show()
                 progressDialog.setCancelable(false)


                 CDT = object : CountDownTimer(5000, 1000) {
                     override fun onTick(millisUntilFinished: Long) {
                         progressDialog.setMessage("Please wait.." + i.toString() + " sec")
                         i--
                     }
                     override fun onFinish() {
                         progressDialog.dismiss()
                     }

                 }.start()


                 intent = Intent(this, MainActivity::class.java)
                 startActivity(intent)
             }
         }




    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
    private fun passwordValidation(): Boolean {
        var btn_Pass = findViewById<EditText>(R.id.newPassword)
        var btn_CPass = findViewById<EditText>(R.id.confirmPassword)

        var btn_Password = btn_Pass.text.toString().trim()
        var btn_ConfirmPass = btn_CPass.text.toString().trim()

         if (btn_Password.isEmpty()) {
            btn_Pass.setError("Please Enter Password")
            return false
        } else if (btn_ConfirmPass.isEmpty()) {
            btn_CPass.setError("Please Enter Confirm Password")
            return false
        } else if (btn_Password.length <= 7) {
             btn_CPass.setError("Please Too Short")
            return false
        } else if (!isValidPasswordFormat(btn_Password)) {
            btn_Pass.setError("Password Not Correct format")
            return false
        }
         else if (btn_ConfirmPass != btn_Password) {
             btn_Pass.setError("Password Mismatched")
             btn_Pass.requestFocus()
             return false

         } else {
            return true
        }
    }

    private fun isValidPasswordFormat(password: String): Boolean {
        val passwordREGEX = Pattern.compile(
                "^" +
                        "(?=.*[0-9])" +         //at least 1 digit
                        "(?=.*[a-z])" +         //at least 1 lower case letter
                        "(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        "(?=\\S+$)" +           //no white spaces
                        ".{8,}" +               //at least 8 characters
                        "$"
        );
        return passwordREGEX.matcher(password).matches()
    }



}




