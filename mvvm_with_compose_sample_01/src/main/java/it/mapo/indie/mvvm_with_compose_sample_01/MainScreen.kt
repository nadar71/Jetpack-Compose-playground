package it.mapo.indie.mvvm_with_compose_sample_01

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen() {
    Log.d("DEBUG_ROUTING", "MainScreen: start app.")
    // Init the navigation common object, like navHostController
    // AppNavigation.navigationInit()
    val navController = rememberNavController()

    NavigationGraph(
        navController = navController,
    )
}
