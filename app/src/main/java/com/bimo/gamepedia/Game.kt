package com.bimo.gamepedia

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

class Game (
    val imgGame : Int,
    val nameGame : String,
    val descGame: String
    ): Parcelable {

}