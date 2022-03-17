package it.mapo.indie.app_expandable_list

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.mapo.indie.app_expandable_list.dummydata.SampleData
import it.mapo.indie.app_expandable_list.model.Message
import it.mapo.indie.app_expandable_list.ui.theme.ComposeTutorialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import it.mapo.indie.app_expandable_list.component.MessageCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme{
                Conversation(SampleData.conversationSample)
            }
        }
    }
}




@Composable
fun Conversation(msgs: List<Message>) {
    LazyColumn {
        items(msgs) {msg ->
            MessageCard(msg)
        }
    }
}


// ---------------------------------------- PREVIEWS -----------------------------------------------
@Preview (name = "Light Mode", showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard(){
    ComposeTutorialTheme {
        MessageCard(Message("Gil", "Hello guys"))
    }
}


@Preview (name = "Light Mode", showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewConversation(){
    ComposeTutorialTheme{
        Conversation(SampleData.conversationSample)
    }
}




