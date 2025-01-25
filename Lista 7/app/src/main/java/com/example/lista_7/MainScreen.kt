package com.example.lista7

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.Lista_7.StudentDetailScreen
import com.example.lista_7.StudentViewModel

@Composable
fun MainScreen(viewModel: StudentViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list_screen") {
        composable("list_screen") {
            StudentListScreen(viewModel) { selectedStudent ->
                viewModel.selectStudent(selectedStudent)
                navController.navigate("detail_screen")
            }
        }
        composable("detail_screen") {
            StudentDetailScreen(viewModel)
        }
    }
}