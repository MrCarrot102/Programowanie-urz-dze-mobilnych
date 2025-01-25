package com.example.maslolot.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(context: Context){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "start_screen"){
        composable("start_screen") { StartScreen(navController)}
        composable("game_screen") { GameScreen(navController)}
        composable("high_scores") { HighScoresScreen(context)}
        composable("game_over/{score}") { backStackEntry ->
            val score = backStackEntry.arguments?.getString("score")?.toInt() ?: 0
            GameOverScreen(navController, score, context)
        }
    }

}