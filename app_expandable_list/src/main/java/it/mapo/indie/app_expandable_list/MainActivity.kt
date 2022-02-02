package it.mapo.indie.app_expandable_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import it.mapo.indie.app_expandable_list.model.Message

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

@Composable
fun MessageCard(msg: Message){
    Row {
        Image(
            painter = painterResource(id = R.drawable.gil ),
            contentDescription = "Contact profile picture"
        )
        Column {
            Text(text = msg.author)
            Text(text = msg.body)
        }
    }
}



// ---------------------------------------- PREVIEWS -----------------------------------------------
@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(Message("Simo","Hello guys"))
}

