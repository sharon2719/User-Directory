package com.example.userdirectoryapp.data.repository

import com.example.userdirectoryapp.data.model.User
import com.example.userdirectoryapp.data.network.ApiService

class UserRepository(private val apiService: ApiService) {
    suspend fun getUsers(): List<User> = apiService.getUsers()
}
