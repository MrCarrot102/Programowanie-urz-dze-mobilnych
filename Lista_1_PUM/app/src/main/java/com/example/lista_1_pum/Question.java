package com.example.lista_1_pum;

public class Question {
    private String question;
    private String[] answer;
    private int correctAnswerIndex;

    public Question(String question, String[] answer, int correctAnswerIndex){
        this.question=question;
        this.answer=answer;
        this.correctAnswerIndex=correctAnswerIndex;
    }
    public String getQuestion(){
        return question;
    }
    public String[] getAnswer(){
        return answer;
    }
    public int getCorrectAnswerIndex(){
        return correctAnswerIndex;
    }
}

