package it.mapo.indie.app_expandable_list

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import it.mapo.indie.app_expandable_list.component.MessageCard
import it.mapo.indie.app_expandable_list.dummydata.SampleData
import it.mapo.indie.app_expandable_list.model.Message
import it.mapo.indie.app_expandable_list.ui.theme.ComposeTutorialTheme

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




