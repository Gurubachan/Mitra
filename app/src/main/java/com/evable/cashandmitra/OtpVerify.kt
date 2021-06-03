package com.evable.cashandmitra

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class OtpVerify : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verify)
        var enterOtp=findViewById<EditText>(R.id.enterOtp)
        var verifyOtp=findViewById<Button>(R.id.verifyOtp)

        var otpEnter = enterOtp.text.toString().trim()




        verifyOtp.setOnClickListener {
            if (enterOtp.getText().toString().equals("")) {
                enterOtp.setError("Enter Otp")

            }
            else if(enterOtp.getText().toString().length<6)
            {

                enterOtp.setError("Enter a valid otp")
            }

           else if(enterOtp.text.toString().length==6)
            {
                //progress bar
                val CDT: CountDownTimer
                var i = 5
                val progressDialog = ProgressDialog(this)
                progressDialog.setTitle("Otp Verifying")
                progressDialog.setCancelable(false)
                progressDialog.show()
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
                intent = Intent(this, ChangePassword::class.java)
                startActivity(intent)
            }
            else
            {
             Toast.makeText(this, "InValid Otp", Toast.LENGTH_SHORT).show();

            }



        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}