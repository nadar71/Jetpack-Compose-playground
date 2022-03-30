package it.mapo.indie.app_drawicons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import it.mapo.indie.app_drawicons.ui.theme.ComposableDrawIconsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getAllIcons()
        }
    }
}



@Composable
@Preview(showBackground = true)
fun getAllIcons() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            InstagramIcon()
            FacebookIcon()
            MessengerIcon()
        }

        Row(horizontalArrangement = Arrangement.SpaceAround) {
            GoogleIcon()
            GetYoutubeIcon()
            GetGooglePhotosIcon()
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            GoogleAssistant()
            GoogleAds()
            GetGoogleVoiceSearch()
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            GetStackOverflow()
            GetSpotify()
            GetTrello()
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            GetZoom()
            GetAndroidIcon()
            GetWeatherApp()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    ComposableDrawIconsTheme {
        // Greeting("Android")
        // draw icons
        // getAllIcons()
        FacebookIcon()
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}