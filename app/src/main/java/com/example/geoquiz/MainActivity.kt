package com.example.geoquiz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    val currentQuestionIndex = 0
    val currentQuestion = questionList[currentQuestionIndex]

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "GeoQuiz", fontSize = 24.sp, modifier = Modifier.padding(bottom = 24.dp))
        Text(text = currentQuestion.text, fontSize = 18.sp)
    }
}

@Preview(showBackground = true, name = "Шаг 1: Каркас")
@Composable
fun PreviewStep1() {
    QuizScreen()
}