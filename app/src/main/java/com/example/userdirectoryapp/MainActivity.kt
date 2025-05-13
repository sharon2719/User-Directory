package com.example.userdirectoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.userdirectoryapp.data.model.User
import com.example.userdirectoryapp.data.network.ApiService
import com.example.userdirectoryapp.data.repository.UserRepository
import com.example.userdirectoryapp.ui.MainViewModel
import com.example.userdirectoryapp.ui.UserDetailsScreen
import com.example.userdirectoryapp.ui.UserListScreen
import com.example.userdirectoryapp.ui.theme.UserDirectoryAppTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val apiService = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val repository = UserRepository(apiService)
        val viewModel = MainViewModel(repository)

        setContent {
            UserDirectoryAppTheme {
                val users by viewModel.users.collectAsState()
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "list",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("list") {
                            UserListScreen(users = users) { selectedUser ->
                                navController.currentBackStackEntry
                                    ?.savedStateHandle
                                    ?.set("user", selectedUser)
                                navController.navigate("details")
                            }
                        }
                        composable("details") {
                            val user = navController
                                .previousBackStackEntry
                                ?.savedStateHandle
                                ?.get<User>("user")
                            user?.let { UserDetailsScreen(it) }
                        }
                    }
                }
            }
        }
    }
}
