package com.example.curriculumvitaev2



import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.text.Editable
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.drawToBitmap
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream





class MainActivity : AppCompatActivity() {
    private var SELECT_PICTURE = 200
    private lateinit var fullName:Editable
    private lateinit var age:Editable
    private lateinit var email: Editable

    private lateinit var  gender: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fullName = fullNameField.editText?.text!!
        age = ageField.editText?.text!!
        email = emailField.editText?.text!!



        plusButton.setOnClickListener {
            imageChooser()

        }


        nextButton.setOnClickListener {
            checkUserInput()

        }






    }
    private fun imageChooser() {

        // create an instance of the
        // intent of the type image
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)  {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                val selectedImageUri = data?.data
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    profilePic.setImageURI(selectedImageUri)

                }
            }
        }
    }

    private fun checkSelectedGender():String{

    if(maleRadioButton.isChecked){

     gender = maleRadioButton.text.toString()

    }
     if(femaleRadioButton.isChecked){
        gender= femaleRadioButton.text.toString()

    }

return  gender;


}
    private fun Toast(message: String) {

        android.widget.Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

    }
    private fun checkUserInput(){


        val bitmap = profilePic.drawToBitmap();
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val profile_pic = stream.toByteArray()



        if(fullName.isEmpty()){
            fullNameField.error = "Must not be empty";
        }
        if(age.isEmpty()){
            ageField.error = "Must not be empty";
        }
        if(email.isEmpty()){
            emailField.error = "Must not be empty";
        }
        if(!maleRadioButton.isChecked && !femaleRadioButton.isChecked) {

            Toast("Please select a gender");


        }
        if (!EMAIL_ADDRESS.matcher(email).matches()) {
            emailField.error = "Verify your email address";

        }
        else {


            val i = Intent(this, SecondActivity::class.java)

            i.putExtra("key_name",fullName.toString());
            i.putExtra("key_age",age.toString());
            i.putExtra("key_email",email.toString());
            i.putExtra("key_gender",checkSelectedGender());
            i.putExtra("key_profile_picture", profile_pic);

            startActivity(i)
        }



    }


}