package com.example.maslolot.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import com.example.maslolot.model.Bullet
import com.example.maslolot.model.Enemy
import com.example.maslolot.model.GameState
import com.example.maslolot.model.Player
import com.example.maslolot.ui.components.*
import kotlinx.coroutines.delay
import kotlin.random.Random
@Composable
fun GameScreen(navController:NavHostController){
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp

   val playerState = remember{
        mutableStateOf(Player(x = (screenWidth / 2 - 24 ).toFloat(), y = (screenHeight - 100 ).toFloat(), speed = 10f))
   }
    val enemies = remember { mutableStateListOf<Enemy>()}
    val bullets = remember { mutableStateListOf<Bullet>()}
    val score = remember {mutableStateOf(0)}

    LaunchedEffect(Unit) {
        while(true) {
            // poruszanie sie przeciwnikow
            enemies.forEach { it.y += it.speed }
            // usuwanie ich poza ekranem
            enemies.removeAll { it.y > screenHeight }
            // generowanie nowych przeciwnikow
            if (Random.nextFloat() < 0.02) {
                enemies.add(
                    Enemy(
                        x = Random.nextInt(0, screenWidth).toFloat(),
                        y = 0f,
                        speed = Random.nextFloat() * 3 + 1
                    )
                )
            }
            // poruszanie pociskow
            bullets.forEach { it.y -= it.speed }
            // usuwanie poza ekranem
            bullets.removeAll { it.y < 0 }
            // wykrywanie kolizji
            val iterator = bullets.iterator()
            while (iterator.hasNext()) {
                val bullet = iterator.next()
                val hitEnemy = enemies.find { enemy ->
                    bullet.x in (enemy.x - 20)..(enemy.x + 20) &&
                            bullet.y in (enemy.y - 20)..(enemy.y + 20)
                }
                if (hitEnemy != null) {
                    iterator.remove()
                    enemies.remove(hitEnemy)
                    score.value += 10
                }
            }
            if (enemies.any { enemy ->
                    playerState.value.x in (enemy.x - 40)..(enemy.x + 40) &&
                            playerState.value.y in (enemy.y - 40)..(enemy.y + 40)
                }) {
                navController.navigate("game_over/${score.value}")
                return@LaunchedEffect
            }
            delay(16L)
        }
    }
    LaunchedEffect(Unit) {
        while(true){
            bullets.add(
                Bullet(
                    x = playerState.value.x +20f,
                    y = playerState.value.y,
                    speed = 10f
                )
            )
            delay(500L)
        }
    }


    Box(modifier = Modifier.fillMaxSize()){
        BackgroundComposable()
        PlayerComposable(
            player = playerState.value,
            onMove = { dx, dy ->
                playerState.value = playerState.value.copy(
                    x = (playerState.value.x + dx).coerceIn(0f, screenWidth.toFloat()),
                    y = (playerState.value.y + dy).coerceIn(0f, screenHeight.toFloat())
                )
            }
        )
        EnemyComposable(enemies = enemies)
        BulletComposable(bullets = bullets)
        ScoreboardComposable(score  = score.value)
    }
}
