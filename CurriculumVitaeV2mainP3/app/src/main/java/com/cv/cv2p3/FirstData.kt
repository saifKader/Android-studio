package com.cv.cv2p3

import com.google.gson.annotations.SerializedName

data class FirstData(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("age") val age: String,
    @SerializedName("gender") val gender: String,
)