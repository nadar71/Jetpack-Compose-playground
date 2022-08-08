package it.mapo.indie.mvvm_with_compose_sample_01

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.BackspaceCommand
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import it.mapo.indie.mvvm_with_compose_sample_01.util.GeneralUtility

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EditTextTestScreen(navController : NavHostController) {

    Log.d("DEBUG_ROUTING", "EditTextTestScreen: INSIDE")

    val maxLength = 8
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    var noteText by remember { mutableStateOf("") }
    var priceText by remember { mutableStateOf("") }
    val scaffoldState = rememberScaffoldState()



    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState,

        ) {

        ConstraintLayout(
            Modifier
                .background(Color.Black)
                .fillMaxSize(),
        ) {

            val (
                headerSection,
            ) = createRefs()

            ConstraintLayout(
                Modifier
                    .constrainAs(headerSection) {
                        top.linkTo(parent.top, margin = 0.dp)
                        start.linkTo(parent.start, margin = 0.dp)
                        end.linkTo(parent.end, margin = 0.dp)
                    }
                    .fillMaxWidth()
            ) {
                val (
                    mainTopAppbar,
                    subscription_icon,
                    subscriptionCost_row,
                ) = createRefs()


                TopAppBar(
                    modifier = Modifier
                        .constrainAs(mainTopAppbar) {
                            top.linkTo(parent.top, margin = 0.dp)
                        },
                    backgroundColor = Color.Green,
                    contentColor = colorResource(id = R.color.white),
                    elevation = 0.dp
                ) {
                    ConstraintLayout(
                        Modifier
                            .fillMaxSize()
                            .wrapContentHeight(Alignment.CenterVertically)
                    ) {
                        val (save_btn) = createRefs()
                        ClickableText(
                            text = AnnotatedString("Save"),
                            Modifier
                                .constrainAs(save_btn) {
                                    end.linkTo(parent.end, margin = 16.dp)
                                    top.linkTo(parent.top, margin = 0.dp)
                                    bottom.linkTo(parent.bottom, margin = 8.dp)

                                },
                            style = TextStyle(
                                color = colorResource(id = R.color.white),
                                textAlign = TextAlign.Right,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            onClick = {

                            }
                        )
                    }
                }





                Row(
                    modifier = Modifier
                        .constrainAs(subscriptionCost_row) {
                            start.linkTo(parent.start, margin = 16.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                            top.linkTo(subscription_icon.bottom, margin = 16.dp)
                        }
                        .alpha(0.6f),
                )
                {
                    /*Box() {
                        Row { // note*/

                    Text(
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(4.dp)
                            .wrapContentSize(align = Alignment.CenterEnd),
                        text = "€",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.white),
                        textAlign = TextAlign.End,
                        fontSize = 14.sp,
                    )


                    BasicTextField(
                        value = priceText,
                        onValueChange = { newText: String ->
                            priceText = GeneralUtility.filterNumberInput(newText.take(maxLength))
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done,
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                // focusManager.clearFocus()
                                keyboardController?.hide()
                                BackspaceCommand()
                            }
                        ),
                        modifier = Modifier
                            .focusRequester(focusRequester)
                            .weight(0.7f)
                            .wrapContentSize(align = Alignment.CenterStart)
                            .padding(4.dp)
                            .background(color = Color.Blue),
                        enabled = true,
                        textStyle = TextStyle(
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Start,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        ),

                        singleLine = true,
                        cursorBrush = SolidColor(colorResource(id = R.color.white)),
                        decorationBox = { innerTextField ->
                            Row(
                                modifier = Modifier
                                    .padding(0.dp, 0.dp, 0.dp, 0.dp),
                            ) {
                                if (priceText.isEmpty()) {
                                    Text(
                                        modifier = Modifier
                                            .alpha(0.5f)
                                            .padding(0.dp, 0.dp, 0.dp, 0.dp),
                                        text = "0.00",
                                        color = colorResource(id = R.color.white),
                                        textAlign = TextAlign.Start,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            innerTextField()
                        },
                    )
                }
            }
        }
    }
    /*}
    }*/
}