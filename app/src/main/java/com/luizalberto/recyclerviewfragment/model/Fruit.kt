package com.luizalberto.recyclerviewfragment.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Fruit(
    val genus: String,
    val name: String,
    @PrimaryKey val id: Int,
    val family: String,
    val order: String,
    @Embedded val nutritions: Nutrition
) : Parcelable