package `in`.cashand.mitra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tv_register = findViewById<TextView>(R.id.tv_register)
        tv_register.setOnClickListener(View.OnClickListener {
            val register = Intent(this, RegisterActivity::class.java)
            startActivity(register)
        })
    }
}