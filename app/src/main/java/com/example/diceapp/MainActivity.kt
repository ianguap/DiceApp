package com.example.diceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceapp.ui.theme.DiceAppTheme
import android.widget.ImageView
import android.widget.Button
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var roll by remember { mutableStateOf(1) }
    Column() {
        when (roll){
            1 -> Image(painter = painterResource(id = R.drawable.dicesideone), contentDescription = stringResource(id = R.string.Dice_One))
            2 -> Image(painter = painterResource(id = R.drawable.dicesidetwo), contentDescription = stringResource(id = R.string.Dice_Two))
            3 -> Image(painter = painterResource(id = R.drawable.dicesidethree), contentDescription = stringResource(id = R.string.Dice_Three))
            4 -> Image(painter = painterResource(id = R.drawable.dicesidefour), contentDescription = stringResource(id = R.string.Dice_Four))
            5 -> Image(painter = painterResource(id = R.drawable.dicesidefive), contentDescription = stringResource(id = R.string.Dice_Five))
            6 -> Image(painter = painterResource(id = R.drawable.dicesidesix), contentDescription = stringResource(id = R.string.Dice_Six))
        }
        Text(
            text = "Hello $name!")

        Button(
            onClick = { roll=(1..6).random()},


        ) {
            Text("Roll")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiceAppTheme {
        Greeting("Android")
    }
}
