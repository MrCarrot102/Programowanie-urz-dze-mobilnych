package com.example.maslolot.ui

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import com.example.maslolot.utils.HighScoresManager


@Composable
fun HighScoresScreen(context: Context) {
    val highScores = mutableStateListOf<Pair<String,Int>>()
    LaunchedEffect(Unit) {
        val loadedScores = HighScoresManager.loadScores(context)
        highScores.clear()
        highScores.addAll(loadedScores)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "High Scores")
        highScores.forEach{ (name, score) ->
            Text(text = "$name - $score")
        }
    }
}