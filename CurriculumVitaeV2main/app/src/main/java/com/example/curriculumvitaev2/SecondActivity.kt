package com.example.curriculumvitaev2

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_activity.*
import kotlin.properties.Delegates


private var androidSeekBarValue by Delegates.notNull<Int>();
private var   iosSeekBarValue by Delegates.notNull<Int>();
private var    flutterSeekBarValue by Delegates.notNull<Int>();
val language = mutableListOf<String>()
val hobby = mutableListOf<String>()



class SecondActivity : AppCompatActivity() {


    private fun checklSelectedLanguage(){
        if (arabicCheckBox.isChecked){
            language.add(arabicCheckBox.text.toString())
        }
        if (frenchCheckBox.isChecked){
            language.add(frenchCheckBox.text.toString())
        }
        if (englishCheckBox.isChecked){
            language.add(englishCheckBox.text.toString())
        }
    }
    private fun checkSelectedHobby(){
        if (musicCheckBox.isChecked){
            hobby.add(musicCheckBox.text.toString())
        }
        if (sportCheckBox.isChecked){
            hobby.add(sportCheckBox.text.toString())
        }
        if (gamesCheckBox.isChecked){
            hobby.add(gamesCheckBox.text.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)



secondActivitySubmitButton.setOnClickListener {
    language.clear()

    checklSelectedLanguage()
    hobby.clear()
    checkSelectedHobby()
    val separator = " "

    val selectedLanguage = java.lang.String.join(separator, language)

    val selectedHobby = java.lang.String.join(separator, hobby)

    val fullName = intent.getStringExtra("key_name")
    val age = intent.getStringExtra("key_age")
    val email = intent.getStringExtra("key_email")
    val gender = intent.getStringExtra("key_gender")
    val extras = intent.extras
    val byteArray = extras!!.getByteArray("key_profile_picture")
    val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)



androidSeekBarValue=androidSeekBar.progress*10;
    iosSeekBarValue=iosSeekBar.progress*10;
    flutterSeekBarValue=flutterSeekBar.progress*10;
    val i = Intent(this, ThirdActivity::class.java)
    i.putExtra("key_name", fullName.toString());
    i.putExtra("key_age", age.toString());
    i.putExtra("key_email", email.toString());
    i.putExtra("key_gender", gender.toString());
    i.putExtra("key_android_seekbar", androidSeekBarValue.toString());
    i.putExtra("key_ios_seekbar", iosSeekBar.progress.toString());
    i.putExtra("key_flutter_seekbar", flutterSeekBar.progress.toString());
    i.putExtra("key_language", selectedLanguage);
    i.putExtra("key_hobby",selectedHobby);
    i.putExtra("key_profile_picture",byteArray);

    startActivity(i)

}

        androidSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                progress()
            }
        })
        iosSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                progress()

            }
        })
        flutterSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                progress()

            }
        })



    }
    private fun progress() {
        if (androidSeekBar.progress > 8 && androidSeekBar.progress > iosSeekBar.progress && androidSeekBar.progress > flutterSeekBar.progress) {
            Toast("Your excellent at android ")
        } else if (iosSeekBar.progress > 8 && iosSeekBar.progress > androidSeekBar.progress && iosSeekBar.progress > flutterSeekBar.progress) {
            Toast("Your excellent at ios ")
        } else if (flutterSeekBar.progress > 8 && flutterSeekBar.progress > androidSeekBar.progress && flutterSeekBar.progress > iosSeekBar.progress) {
            Toast("Your excellent at flutter ")
        } else if (flutterSeekBar.progress < 3 && androidSeekBar.progress < 3 && iosSeekBar.progress < 3) {
            Toast("You have to work on your skills ")
        } else {


            Toast("You have good skills")
        }


    }

    private fun Toast(message: String) {

        android.widget.Toast.makeText(this,message, android.widget.Toast.LENGTH_SHORT).show()


    }



    }
