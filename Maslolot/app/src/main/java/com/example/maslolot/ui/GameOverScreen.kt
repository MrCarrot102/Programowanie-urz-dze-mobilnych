package com.example.maslolot.ui
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController
import com.example.maslolot.utils.HighScoresManager

@Composable
fun GameOverScreen(navController: NavHostController, score: Int, context : Context){
    val playerName = remember { mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text="Game Over")
        Text(text="Your Score: $score")

        TextField(
            value = playerName.value,
            onValueChange = {
                if (it.length <= 4) {
                    playerName.value = it
                }
            },
            label = {Text("Enter your name (4 letters max)")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Button(onClick = {
            if(playerName.value.isNotEmpty()){
                HighScoresManager.saveScore(context, playerName.value,score)
            }
            navController.navigate("start_screen")
        }){
            Text(text= "Submit")
        }
    }
}
