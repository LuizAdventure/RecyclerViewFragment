package com.luizalberto.recyclerviewfragment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Nutrition(
    val carbohydrates: Float,
    val protein: Float,
    val fat: Float,
    val calories: Float,
    val sugar: Float
) : Parcelable