package com.example.sdcard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val regno:EditText=findViewById(R.id.regno)
        val name:EditText=findViewById(R.id.name)
        val cgpa:EditText=findViewById(R.id.cgpa)
        val btnsave:Button=findViewById(R.id.btnsave)
        val btnload:Button=findViewById(R.id.btnload)

        btnsave.setOnClickListener(){
            val regnoval=regno.text.toString()
            val nameval=name.text.toString()
            val cgpaval=cgpa.text.toString()
            val file= File(getExternalFilesDir(null),"student_info.txt")
            val fos=FileOutputStream(file)
            fos.write("$regnoval,$nameval,$cgpaval".toByteArray())
            regno.setText("")
            name.setText("")
            cgpa.setText("")
            fos.close()
        }
        btnload.setOnClickListener(){
            val file=File(getExternalFilesDir(null),"student_info.txt")
            val fis=FileInputStream(file)
            val isr=InputStreamReader(fis)
            val br=BufferedReader(isr)
            val parts=br.readLine().toString().split(",")
            regno.setText(parts[0])
            name.setText(parts[1])
            cgpa.setText(parts[2])
            fis.close()
        }
    }
}