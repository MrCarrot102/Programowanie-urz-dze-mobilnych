package com.example.maslolot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.maslolot.R
import com.example.maslolot.model.Player

@Composable
fun PlayerComposable(player: Player, onMove: (Float, Float) -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.player),
        contentDescription = "Player",
        modifier = Modifier
            .offset(x = player.x.dp, y = player.y.dp)
            .size(100.dp)
            .pointerInput(Unit){
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    onMove(dragAmount.x, dragAmount.y)
                }
            }
    )
}