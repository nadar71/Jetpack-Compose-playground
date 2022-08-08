package it.mapo.indie.mvvm_with_compose_sample_01

import User
import UserViewModel
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import it.lemonpie.subscriptionmanager.feature_subscription.presentation.navigation.AppNavigation
import java.util.*

@Composable
fun UserScreen(navController : NavHostController, vm : UserViewModel = viewModel()) {
    Log.d("DEBUG_ROUTING", "UserView: inside.")

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
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Action") },
                onClick = {
                    // AppNavigation.appNavHostController.navigate(
                    navController.navigate(
                        "editTextTest"
                    ){
                        popUpTo("editTextTest") {
                            inclusive = true
                            Log.d("DEBUG_ROUTING", "floatingActionButton: PRESSED, nvaigation started.")
                        }
                    }
                }
            )
        },
    )
}