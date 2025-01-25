package com.example.maslolot.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ScoreboardComposable(score: Int = 0){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)){
        Text(text = "Score: $score")
    }
}