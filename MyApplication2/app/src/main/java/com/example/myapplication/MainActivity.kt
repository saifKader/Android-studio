package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
   //verify opencv is loaded
    private static string TAG = "MainActivity";
    static{


        if(OpenCVLoader.initDebug()){
            Log.d("OpenCV", "OpenCV loaded successfully")
        } else {
            Log.d("OpenCV", "OpenCV not loaded")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}