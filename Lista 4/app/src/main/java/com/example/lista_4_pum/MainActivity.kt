package com.example.lista_4_pum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lista_4_pum.ui.theme.Lista_4_pumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                QuizApp()
            }
        }
    }
}


@Composable
fun QuizApp() {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedAnswerIndex by remember { mutableStateOf(-1) }
    var score by remember { mutableStateOf(0) }

    val currentQuestion = questions[currentQuestionIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Nagłówek pytania i postęp
        Text(
            text = "Pytanie ${currentQuestionIndex + 1}/${questions.size}",
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))

        LinearProgressIndicator(
            progress = (currentQuestionIndex + 1) / questions.size.toFloat(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Tekst pytania
        Text(text = currentQuestion.text, style = MaterialTheme.typography.body1)

        // Lista odpowiedzi
        Spacer(modifier = Modifier.height(16.dp))
        currentQuestion.options.forEachIndexed { index, option ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { selectedAnswerIndex = index },
                elevation = 4.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    RadioButton(
                        selected = selectedAnswerIndex == index,
                        onClick = { selectedAnswerIndex = index }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = option)
                }
            }
        }

        // Przycisk "Następne"
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                if (selectedAnswerIndex == currentQuestion.correctAnswerIndex) {
                    score++
                }
                if (currentQuestionIndex < questions.size - 1) {
                    currentQuestionIndex++
                    selectedAnswerIndex = -1
                } else {
                    // Koniec quizu
                    Toast.makeText(LocalContext.current, "Twój wynik: $score/${questions.size}", Toast.LENGTH_LONG).show()
                }
            },
            enabled = selectedAnswerIndex != -1,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = if (currentQuestionIndex < questions.size - 1) "Następne" else "Zakończ")
        }
    }
}
