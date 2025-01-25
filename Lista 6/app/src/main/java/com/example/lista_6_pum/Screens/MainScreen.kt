package com.example.lista_6_pum.Screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.lista_6_pum.data.Data

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.List, contentDescription = "Listy zadań") },
                    label = { Text(text = "Listy zadań") },
                    selected = false,
                    onClick = { navController.navigate("TaskListScreen") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Star, contentDescription = "Oceny") },
                    label = { Text(text = "Oceny") },
                    selected = false,
                    onClick = { navController.navigate("GradeListScreen") }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "TaskListScreen",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = "TaskListScreen") {
                TaskListScreen(navController = navController, data = Data) // Pass arguments
            }
            composable(route = "GradeListScreen") {
                GradeListScreen(data = Data)
            }
            composable(route = "TaskDetailsScreen/{listId}") { backStackEntry ->
                val listId = backStackEntry.arguments?.getString("listId")?.toIntOrNull()
                listId?.let { id ->
                    TaskDetailsScreen(Data[id])
                }
            }
        }
    }
}