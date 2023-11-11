package org.hyperskill.secretdiary

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.datetime.*
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {

    val savebtn : Button by lazy {findViewById(R.id.btnSave)}
    val writing : EditText by lazy {findViewById(R.id.etNewWriting)}
    val diary : TextView by lazy {findViewById(R.id.tvDiary) }
    var diaryList = mutableListOf<String>() //list of item
    var diaryText = "" //to help process string

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Clear text in case of lifecycle changes
        diary.setText("")

        savebtn.setOnClickListener{
            //Get time now in local format
            val epochMilliseconds = Clock.System.now().toEpochMilliseconds()
            val currentInstant = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date(epochMilliseconds))



            //put if EditText is not empty
            if(writing.text.toString().trim().isNotBlank()) {

                //Add items to a list use new line for content
                diaryList.add("${currentInstant.toString()}\n${writing.text.toString()}")

                //Display items last added top on the list first added last
               for (i in diaryList.size - 1 downTo 0 ) {
                   if(i == diaryList.size - 1) diaryText = diaryList[i] + '\n'
                   else diaryText += '\n' + diaryList[i] + '\n'
               }

                //remove unnecessary spaces at the end and set to textView
                diary.setText(diaryText.trim())

                //clear editText
                writing.setText("")
            }
            else {
                //comment when user tries to save emoty text
                Toast.makeText(applicationContext, "Empty or blank input cannot be saved",Toast.LENGTH_LONG).show()
            }
        }
    }

}
