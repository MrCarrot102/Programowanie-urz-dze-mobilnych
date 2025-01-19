package com.example.lista_6_pum.Screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lista_6_pum.data.ExerciseList
import androidx.compose.foundation.lazy.items


@Composable
fun TaskDetailsScreen(exerciseList: ExerciseList){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column {
            Text(
                text = "${exerciseList.subject.name} - Lista Zadań",
                style = MaterialTheme.typography.titleMedium
            )
            if (exerciseList.exercises.isEmpty()){
                Text(
                    text= "Brak zadań",
                    style = MaterialTheme.typography.bodyMedium
                )
            } else {
                LazyColumn {
                    items(exerciseList.exercises) { exercise ->
                        ListItem(
                            headlineContent =  {Text(exercise.content)},
                            supportingContent = { Text("Punkty: ${exercise.points}")}
                        )
                    }
                }
            }
        }
    }


}