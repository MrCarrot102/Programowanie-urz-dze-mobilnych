package com.example.lista_4_pum

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

val questions = listOf(
    Question("Jaka właściwość ciała określa stosunek masy do objętości?", listOf("Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"), 2),
    Question("Co mierzy siła?", listOf("Moc", "Przyspieszenie", "Ciśnienie", "Newton"), 3),
    // Dodaj więcej pytań...
)