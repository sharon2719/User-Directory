package com.example.userdirectoryapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.userdirectoryapp.data.model.User

@Composable
fun UserDetailsScreen(user: User) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Name: ${user.name}", style = MaterialTheme.typography.titleLarge)
        Text("Email: ${user.email}")
        Text("Phone: ${user.phone}")
        Text("Address: ${user.address.street}, ${user.address.city}")
    }
}
