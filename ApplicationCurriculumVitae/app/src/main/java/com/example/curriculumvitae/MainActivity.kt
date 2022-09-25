package com.example.curriculumvitae

import android.os.Bundle
import android.text.Editable
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener


class MainActivity : AppCompatActivity() {

    private lateinit var fullName:Editable
    private lateinit var age:Editable
    private lateinit var email:Editable

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layoutivity_main)

        fullName = fullNameField.editText?.text!!
        age = ageField.editText?.text!!
        email = emailField.editText?.text!!

        nextButton.setOnClickListener {
            UserInputCheck()
        }
        resetButton.setOnClickListener {
            Reset()
        }

        androidSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                progress()
            }
        })
        iosSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                progress()
            }
        })
        flutterSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                progress()

            }
        })


    }


    private fun progress() {
        if (androidSeekBar.progress > 80 && androidSeekBar.progress > iosSeekBar.progress && androidSeekBar.progress > flutterSeekBar.progress) {
            Toast("Your excellent at android ")
        } else if (iosSeekBar.progress > 80 && iosSeekBar.progress > androidSeekBar.progress && iosSeekBar.progress > flutterSeekBar.progress) {
            Toast("Your excellent at ios ")
        } else if (flutterSeekBar.progress > 80 && flutterSeekBar.progress > androidSeekBar.progress && flutterSeekBar.progress > iosSeekBar.progress) {
            Toast("Your excellent at flutter ")
        } else if (flutterSeekBar.progress < 30 && androidSeekBar.progress < 30 && iosSeekBar.progress < 30) {
            Toast("You have to work on your skills ")
        } else {


            Toast("You have good skills")
        }


    }

    private fun Toast(message: String) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }


    private fun UserInputCheck() {

        if (fullName!!.isEmpty() || age!!.isEmpty()) {
            Toast("Please fill all fields")

        } else if (!EMAIL_ADDRESS.matcher(email).matches()) {

            Toast.makeText(this, "Verfiy you email adress", Toast.LENGTH_SHORT).show()
        }
    }

    private fun Reset() {


        fullName?.clear()
        age?.clear()
        email?.clear()
        maleRadioButton.isChecked = true
        femaleRadioButton.isChecked = false
        androidSeekBar.progress = 0
        iosSeekBar.progress = 0
        flutterSeekBar.progress = 0


    }


}
