package it.mapo.indie.mvvm_with_compose_sample_01

import User
import UserViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.lemonpie.subscriptionmanager.feature_subscription.presentation.navigation.AppNavigation
import it.mapo.indie.mvvm_with_compose_sample_01.ui.theme.ComposableMvvmComposeTheme
import java.util.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposableMvvmComposeTheme {
                MainScreen()
                // HomeScreen()
                // UserView()
            }
        }
    }
}


@Composable
fun NavigationGraph(
    navController: NavHostController,
) {

    NavHost(
        navController,
        startDestination = "homeScreen"
    ) {

        composable("homeScreen") {
            Log.d("DEBUG_ROUTING", "NavigationGraph: go to home")
            HomeScreen(navController)
        }

        composable("userScreen") {
            Log.d("DEBUG_ROUTING", "UserView: starting route.")
            UserScreen(navController)
        }

        composable("editTextTestScreen") {
            EditTextTestScreen(navController)
        }

    }
}







