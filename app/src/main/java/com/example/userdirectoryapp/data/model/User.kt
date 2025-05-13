package com.example.userdirectoryapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val address: Address
) : Parcelable

@Parcelize
data class Address(
    val street: String,
    val city: String
) : Parcelable
