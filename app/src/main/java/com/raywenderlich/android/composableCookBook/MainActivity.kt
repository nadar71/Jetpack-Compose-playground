package com.raywenderlich.android.composableCookBook

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      showRecipeList()
    }
  }


  @Composable
  @Preview
  fun showRecipeList(){
    Column(modifier = Modifier.fillMaxSize()) {
      TopAppBar(title = {
        Text("ComposableCookBook")
      })
      RecipeList(defaultRecipes)
    }
  }

  @Composable
  @Preview
  fun Greeting() {
    /*Text("Hello, World!",
              style = TextStyle(color = Color.Red),
              fontFamily = FontFamily.SansSerif,
              letterSpacing = TextUnit(12L),
              baselineShift = BaselineShift.Superscript
      )*/
    Column{
      Text("Hello, World!", style = TextStyle(color = Color.Red))
      Text("Hello, Second World!", style = TextStyle(color = Color.Red))
      Text("Hello, Third World!", style = TextStyle(color = Color.Red))
    }
  }
}
