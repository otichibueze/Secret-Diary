package org.hyperskill.secretdiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    val loginbtn : Button by lazy {findViewById(R.id.btnLogin)}
    val loginPin : EditText by lazy {findViewById(R.id.etPin)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginbtn.setOnClickListener{
            if(loginPin.text.toString().trim().isNotBlank()) {
                if(loginPin.text.toString().equals("1234")) {
                    //launch activity
                    val intent = Intent(this, org.hyperskill.secretdiary.MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
                else {
                    loginPin.error = "Wrong PIN!"
                }
            }
            else {
                Toast.makeText(applicationContext, "Enter login pin", Toast.LENGTH_LONG).show()
            }
        }
    }
}