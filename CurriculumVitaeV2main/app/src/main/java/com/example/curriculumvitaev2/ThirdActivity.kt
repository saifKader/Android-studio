package com.example.curriculumvitaev2

import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.third_activity.*
import java.util.*


class ThirdActivity : AppCompatActivity() {





    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)



        val fullName = intent.getStringExtra("key_name")
        val age = intent.getStringExtra("key_age")
        val email = intent.getStringExtra("key_email")
        val gender = intent.getStringExtra("key_gender")
        val androidSeekBarValue = intent.getStringExtra("key_android_seekbar")
        val iosSeekBarValue = intent.getStringExtra("key_ios_seekbar")
        val flutterSeekBarValue = intent.getStringExtra("key_flutter_seekbar")
        val language = intent.getStringExtra("key_language")
        val hobby = intent.getStringExtra("key_hobby")
        val extras = intent.extras
        val byteArray = extras!!.getByteArray("key_profile_picture")
        val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)



        finalFullName.setText("NAME: " + fullName)
        finalFullName.setTextColor(getResources().getColor(R.color.colorPrimary))
        finalAge.setText("Age: " + age)
        finalAge.setTextColor(getResources().getColor(R.color.colorPrimary))
        finalEmail.setText("Email: " +email)
        finalEmail.setTextColor(getResources().getColor(R.color.colorPrimary))
        finalGender.setText("Gender: " +gender)
        finalGender.setTextColor(getResources().getColor(R.color.colorPrimary))
        finalAndroid.setText("AndroidSkill: " +androidSeekBarValue)
        finalAndroid.setTextColor(getResources().getColor(R.color.colorPrimary))
        finalIos.setText("IosSkill: " + iosSeekBarValue)
        finalIos.setTextColor(getResources().getColor(R.color.colorPrimary))
        finalFlutter.setText("FlutterSkill: "+ flutterSeekBarValue)
        finalFlutter.setTextColor(getResources().getColor(R.color.colorPrimary))
        finalLanguages.setText("Languages: " + language)
        finalLanguages.setTextColor(getResources().getColor(R.color.colorPrimary))
        finalHobbies.setText("Hobbies: " + hobby)
        finalHobbies.setTextColor(getResources().getColor(R.color.colorPrimary))
        finalProfilePicture.setImageBitmap(bmp);



    }



}