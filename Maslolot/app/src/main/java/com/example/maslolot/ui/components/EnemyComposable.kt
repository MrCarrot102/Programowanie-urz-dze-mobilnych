package com.example.maslolot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.maslolot.R
import com.example.maslolot.model.Enemy

@Composable
fun EnemyComposable(enemies: List<Enemy> = listOf()){
    enemies.forEach { enemy ->
        Image(
            painter = painterResource(id = R.drawable.enemy),
            contentDescription = "Enemy",
            modifier = Modifier
                .offset(x = enemy.x.dp, y = enemy.y.dp)
                .size(80.dp)
        )
    }
}