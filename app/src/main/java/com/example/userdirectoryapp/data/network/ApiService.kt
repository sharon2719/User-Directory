package com.example.userdirectoryapp.data.network

import com.example.userdirectoryapp.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
