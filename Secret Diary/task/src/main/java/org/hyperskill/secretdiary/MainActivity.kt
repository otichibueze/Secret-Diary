package org.hyperskill.secretdiary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val savebtn : Button by lazy {findViewById(R.id.btnSave)}
    val writing : EditText by lazy {findViewById(R.id.etNewWriting)}
    val Diary : TextView by lazy {findViewById(R.id.tvDiary) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Diary.setText("")

        savebtn.setOnClickListener{
            if(writing.text.toString().trim().isNotBlank()) {
                Diary.setText(writing.text.toString())
                writing.setText("")
            }
            else {
                Toast.makeText(applicationContext, "Empty or blank input cannot be saved",Toast.LENGTH_LONG).show()
            }
        }
    }

}
