package it.mapo.indie.mvvm_with_compose_sample_01

import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import it.lemonpie.subscriptionmanager.feature_subscription.presentation.navigation.AppNavigation

@Composable
fun HomeScreen(navController: NavHostController,){
    Log.d("DEBUG_ROUTING", "HomeScreen: home.")


    Button(onClick = {
        /*AppNavigation.appNavHostController.navigate(
            "userScreen"
        ){
            popUpTo("userScreen") {
                inclusive = true
                Log.d("DEBUG_ROUTING", "userScreen: go.")
            }
        }*/
        // AppNavigation.appNavHostController.navigate(
        navController.navigate(
            "editTextTestScreen"
        ){
            popUpTo("editTextTestScreen") {
                inclusive = true
                Log.d("DEBUG_ROUTING", "Button: PRESSED, GO TO editTextTest.")
            }
        }
    }) {
        Text(text = "Simple Button")
    }

    // EditTextTestScreen(navController)

}