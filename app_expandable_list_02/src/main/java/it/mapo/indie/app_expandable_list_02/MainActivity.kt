package it.mapo.indie.app_expandable_list_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.mapo.indie.app_expandable_list_02.ui.theme.ComposableExpandableList_01_Theme
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableExpandableList_01_Theme {
                MyApp()
            }
        }
    }
}



// column of card (not list yet)
@Composable
fun MyApp(){
    var shouldShowOnBoarding by rememberSaveable{mutableStateOf(true)}

    if (shouldShowOnBoarding) {
        OnBoardingScreen(onContinueClicked = {shouldShowOnBoarding = false})
    }else {
        Greetings()
    }
}

@Composable
fun Greetings(names : List<String> =  List(1000) {"$it"}) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = names ) { name ->
                Greeting(name = name)
            }
    }
}


// single card
@Composable
fun Greeting(name: String) {
    var expanded by remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))  {
        Row (modifier = Modifier
            .padding(24.dp))
        {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            )
            {
                Text(text = "Hello,")
                Text(text = name)
            }

            OutlinedButton(
                onClick = { expanded = !expanded },
            ){
                Text(if (expanded) "Show Less" else "Show More")
            }
        }
    }
}


@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit){
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Welcome to basic navigation with state!")

            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            )
            {
                Text(text = "Continua")
            }
        }
    }
}



// -------------------------------- PREVIEWS -------------------------------------
@Preview(showBackground = true,
    name = "Hello surface",
    widthDp = 320,
    heightDp = 960)
@Composable
fun MyAppPreview() {
    ComposableExpandableList_01_Theme {
        MyApp()
    }
}



@Preview(showBackground = true,
    name = "Hello surface",
    widthDp = 320,
    heightDp = 960)
@Composable
fun OnBoardingScreenPreview() {
    ComposableExpandableList_01_Theme {
        OnBoardingScreen(onContinueClicked = {})
    }
}