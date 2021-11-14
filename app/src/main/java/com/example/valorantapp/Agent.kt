package com.example.valorantapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Agent(
    var name: String ="",
    var roles: String = "",
    var images: Int = 0,
    var bio: String="",
    var Q: String="",
    var QDescription: String="",
    var C: String="",
    var CDescription: String="",
    var E: String="",
    var EDescription: String="",
    var X: String="",
    var XDescription: String="",

) : Parcelable
