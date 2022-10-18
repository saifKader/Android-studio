package com.cv.cv2p3

import com.google.gson.annotations.SerializedName

data class SecondData(
    @SerializedName("androidValue") val androidValue: Int,
    @SerializedName("IosValue") val IosValue: Int,
    @SerializedName("flutterValue") val flutterValue: Int,
    @SerializedName("isArabic") val isArabic: Boolean,
    @SerializedName("isEnglish") val isEnglish: Boolean,
    @SerializedName("isFrench") val isFrench: Boolean,
    @SerializedName("isMusic") val isMusic: Boolean,
    @SerializedName("isSports") val isSports: Boolean,
    @SerializedName("isGames") val isGames: Boolean,
)