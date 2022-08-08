package it.lemonpie.subscriptionmanager.feature_subscription.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


object AppNavigation{
    lateinit var appNavHostController: NavHostController

    @Composable
    fun getNavController(): NavHostController {
        Log.d("DEBUG_ROUTING", "getNavController(): called")
        return rememberNavController()
    }


    @Composable
    fun navigationInit() {
        appNavHostController = getNavController()
        Log.d("DEBUG_ROUTING", "navigationInit(): called, appNavHostController : $appNavHostController")
    }
}


