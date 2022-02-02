package it.mapo.indie.mvvm_with_compose_sample_01.ui

import User
import UserViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun UserView() {
    val vm by remember { mutableStateOf(UserViewModel()) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Users") },
                actions = {
                    IconButton(onClick = {
                        vm.addUser(User(UUID.randomUUID(), "User"))
                    }) {
                        Icon(Icons.Filled.Add, null)
                    }
                })
        },
        content = {
            Column(modifier = Modifier.padding(16.dp)) {
                LazyColumn(modifier = Modifier.fillMaxHeight()) {
                    items(vm.users) {
                        Column {
                            Text(it.name)
                            Text("${it.id}")
                        }

                    }
                }
            }
        }
    )
}