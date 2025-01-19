package com.example.lista_6_pum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.lista_6_pum.Screens.MainScreen

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            val navController = rememberNavController()
            MainScreen(navController)
        }
    }
}
