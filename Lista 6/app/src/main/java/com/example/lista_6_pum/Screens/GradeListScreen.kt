package com.example.lista_6_pum.Screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.lista_6_pum.data.ExerciseList
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.Card

@Composable
fun GradeListScreen(data: List<ExerciseList>) {

    val groupedData = data.groupBy { it.subject.name }

    LazyColumn {

        groupedData.keys.forEach { subjectName ->

            val exercises = groupedData[subjectName] ?: emptyList()
            val averageGrade = exercises.map { it.grade }.average()

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .shadow(4.dp, shape = RoundedCornerShape(4.dp)),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    ListItem(
                        headlineContent = { Text(text = "$subjectName") },
                        supportingContent = { Text(text = "Średnia: %.2f".format(averageGrade)) }
                    )
                }
            }
        }
    }
}
