package com.example.maslolot.ui.components

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.maslolot.model.Bullet


@Composable
fun BulletComposable(bullets: List<Bullet> = listOf()){
    bullets.forEach { bullet ->
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .offset(x = bullet.x.dp, y = bullet.y.dp)
                .background(Color.Red, CircleShape)
                .size(8.dp)
        )
    }
}