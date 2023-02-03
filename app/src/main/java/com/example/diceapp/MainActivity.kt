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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceapp.ui.theme.DiceAppTheme
import android.widget.ImageView
import android.widget.Button

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

    Image(painter = painterResource(id= R.drawable.dice), contentDescription = stringResource(id = R.string.dice))

    val dice = Dice(6)
    val diceRoll = dice.roll()

    val diceImage: imageResource(id = R.drawable.dice)

    val drawableResource = when (diceRoll){
        1 -> R.drawable.dicesideone
        2 -> R.drawable.dicesidetwo
        3 -> R.drawable.dicesidethree
        4 -> R.drawable.dicesidefour
        5 -> R.drawable.dicesidefive
        else -> R.drawable.dicesidesix
    }

    diceImage.setImageResource(drawableResource)

    diceImage.contentDescription = diceRoll.toString()

    Column() {
        Text(
            text = "Hello $name!")

        Button(
            onClick = { diceRoll=(1..6).random()},


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
class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}