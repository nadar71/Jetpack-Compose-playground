package it.lemonpie.subscriptionmanager.feature_subscription.presentation.navigation


sealed class AppDestinationRoutes(var title:String, var screen_route:String){
    object HomeScreen : AppDestinationRoutes("HomeScreen", "homeScreen")
    object UserView : AppDestinationRoutes("UserScreen", "userScreen")
    object EditTextTestScreen : AppDestinationRoutes("EditTextTestScreen", "editTextTestScreen")
}
