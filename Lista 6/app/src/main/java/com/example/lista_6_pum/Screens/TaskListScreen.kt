package com.example.lista_6_pum.Screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lista_6_pum.data.ExerciseList

@Composable
fun TaskListScreen(data: List<ExerciseList>, navController: NavController){
    LazyColumn {
        itemsIndexed(data) { index, item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(4.dp)),
                shape = RoundedCornerShape(8.dp),
            ){
                ListItem(
                    modifier = Modifier
                        .clickable{
                            navController.navigate("TaskDetailsScreen/$index")
                        },
                    headlineContent = { Text(item.subject.name)},
                    supportingContent = { Text("Liczba zadań: ${item.exercises.size}, Ocena: ${item.grade}")}
                )
            }
        }
    }
}