package com.example.maslolot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.maslolot.R
import com.example.maslolot.model.Bullet


@Composable
fun BulletComposable(bullets: List<Bullet> = listOf()){
    bullets.forEach { bullet ->
        Image(
            painter = painterResource(id = R.drawable.bullet),
            contentDescription = "Bullet",
            modifier = Modifier
                .offset(x = bullet.x.dp, y = bullet.y.dp)
                .size(50.dp)
        )
    }
}