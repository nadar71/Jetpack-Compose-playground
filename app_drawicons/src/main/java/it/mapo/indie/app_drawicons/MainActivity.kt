package it.mapo.indie.app_drawicons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import it.mapo.indie.app_drawicons.ui.theme.ComposableCookBookTheme

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
            instagramIcon()
            facebookIcon()
            messengerIcon()
        }

        Row(horizontalArrangement = Arrangement.SpaceAround) {
            googleIcon()
            getYoutubeIcon()
            getGooglePhotosIcon()
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            googleAssistant()
            googleAds()
            getGoogleVoiceSearch()
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            getStackOverflow()
            getSpotify()
            getTrello()
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            getZoom()
            getAndroidIcon()
            getWeatherApp()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    ComposableCookBookTheme {
        // Greeting("Android")
        // draw icons
        // getAllIcons()
        facebookIcon()
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}