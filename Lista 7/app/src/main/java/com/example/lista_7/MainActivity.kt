package com.example.lista_7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lista7.MainScreen
import com.example.lista_7.ui.theme.Lista_7Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: StudentViewModel = viewModel()
            Lista_7Theme {
                MainScreen(viewModel)
            }
        }
    }
}