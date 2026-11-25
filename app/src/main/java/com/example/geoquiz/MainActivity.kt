package com.example.geoquiz

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Question(val text: String, val answer: Boolean)

val questionList = listOf(
    Question("Canberra is the capital of Australia.", true),
    Question("The Pacific Ocean is larger than the Atlantic Ocean.", true),
    Question("The Suez Canal connects the Red Sea and the Indian Ocean.", false),
    Question("The source of the Nile River is in Egypt.", false),
    Question("The Amazon River is the longest river in the Americas.", true),
    Question("Lake Baikal is the world's oldest and deepest freshwater lake.", true)
)

@Composable
fun QuizScreen() {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }

    val isQuizFinished = currentQuestionIndex >= questionList.size

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "GeoQuiz", fontSize = 24.sp, modifier = Modifier.padding(bottom = 24.dp))

        if (!isQuizFinished) {
            val currentQuestion = questionList[currentQuestionIndex]
            Text(text = currentQuestion.text, fontSize = 18.sp, modifier = Modifier.padding(bottom = 24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    if (currentQuestion.answer) score++
                    currentQuestionIndex++
                }) {
                    Text("TRUE")
                }
                Button(onClick = {
                    if (!currentQuestion.answer) score++
                    currentQuestionIndex++
                }) {
                    Text("FALSE")
                }
            }
        } else {
            Text("Викторина завершена!", fontSize = 20.sp)
            Text("Правильных ответов: $score", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true, name = "Шаг 3: Подсчет ответов")
@Composable
fun PreviewStep3() {
    QuizScreen()
}