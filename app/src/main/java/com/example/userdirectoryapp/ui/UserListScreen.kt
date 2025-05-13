package com.example.userdirectoryapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.userdirectoryapp.data.model.User

@Composable
fun UserListScreen(users: List<User>, onUserClick: (User) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(users) { user ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onUserClick(user) }
                    .padding(16.dp)
            ) {
                Text(user.name, style = MaterialTheme.typography.titleMedium)
                Text(user.email, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
