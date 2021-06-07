package `in`.cashand.mitra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    var PASSWORD_PATTERN: String = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"

    val pattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,10}\$")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var et_reg_first_name = findViewById<EditText>(R.id.et_reg_first_name)
        var et_reg_last_name = findViewById<EditText>(R.id.et_reg_last_name)
        var et_reg_phone = findViewById<EditText>(R.id.et_reg_phone)
        var et_reg_email = findViewById<EditText>(R.id.et_reg_email)
        var et_reg_password = findViewById<EditText>(R.id.et_reg_password)
        var et_reg_confirm_password = findViewById<EditText>(R.id.et_reg_confirm_password)
        var btn_register = findViewById<Button>(R.id.btn_register)
        var tv_sign_in = findViewById<TextView>(R.id.tv_sign_in)

        btn_register.setOnClickListener(View.OnClickListener {
            if(et_reg_first_name.text.toString().trim().isEmpty()) {
                //Toast.makeText(this, "Please enter the first name", Toast.LENGTH_LONG).show()
                et_reg_first_name.requestFocus()
                et_reg_first_name.error = "Please enter the first name"
            } else if(et_reg_last_name.text.toString().trim().isEmpty()) {
                //Toast.makeText(this, "Please enter the last name", Toast.LENGTH_LONG).show()
                et_reg_last_name.requestFocus()
                et_reg_last_name.error = "Please enter the last name"
            } else if(et_reg_phone.text.toString().trim().isEmpty()) {
                //Toast.makeText(this, "Please enter the phone number", Toast.LENGTH_LONG).show()
                et_reg_phone.requestFocus()
                et_reg_phone.error = "Please enter the phone number"
            } else if(et_reg_email.text.toString().trim().isEmpty()) {
                //Toast.makeText(this, "Please enter the email address", Toast.LENGTH_LONG).show()
                et_reg_email.requestFocus()
                et_reg_email.error = "Please enter the email address"
            } else if (!(android.util.Patterns.EMAIL_ADDRESS.matcher(et_reg_email.text.toString().trim()).matches())){
                //Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_LONG).show()
                et_reg_email.requestFocus()
                et_reg_email.error = "Please enter a valid email address"
            } else if(et_reg_password.text.toString().trim().isEmpty()) {
                //Toast.makeText(this, "Please enter the password", Toast.LENGTH_LONG).show()
                et_reg_password.requestFocus()
                et_reg_password.error = "Please enter the password"
            } else if(et_reg_password.text.toString().trim().length < 8){
                //Toast.makeText(this, "Please enter a password more than 8 characters", Toast.LENGTH_LONG).show()
                et_reg_password.requestFocus()
                et_reg_password.error = "Please enter a password with atleast 8 characters"
            } else if(et_reg_password.text.toString().trim().length > 10){
                //Toast.makeText(this, "Please enter a password more than 8 characters", Toast.LENGTH_LONG).show()
                et_reg_password.requestFocus()
                et_reg_password.error = "Please enter a password less than 10 characters"
            } else if(!(pattern.containsMatchIn(et_reg_password.text.toString().trim()))){
                /*Toast.makeText(this,
                        " Please enter a password with atleast one digit,\n"
                        + " atleast one lower case letter,\n"
                        + "atleast one upper case letter,\n"
                        + " and atleast one special character", Toast.LENGTH_LONG).show()*/
                et_reg_password.requestFocus()
                et_reg_password.error = "Please enter a password with atleast one digit, atleast one lower case letter, atleast one upper case letter and atleast one special character"
            }


            else if (et_reg_confirm_password.text.toString().trim().isEmpty()) {
                //Toast.makeText(this, "Please confirm the password", Toast.LENGTH_LONG).show()
                et_reg_confirm_password.requestFocus()
                et_reg_confirm_password.error = "Please confirm the password"
            } else if(et_reg_password.text.toString() != et_reg_confirm_password.text.toString()){
                //Toast.makeText(this, "Please confirm the password", Toast.LENGTH_LONG).show()
                et_reg_confirm_password.requestFocus()
                et_reg_confirm_password.error = "Please enter same password to confirm"
            }
        })

        tv_sign_in.setOnClickListener(View.OnClickListener {
            val signIn = Intent(this, MainActivity::class.java)
            startActivity(signIn)
        })

    }
}