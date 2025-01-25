package com.example.maslolot.utils

import android.content.Context
import android.content.SharedPreferences

object HighScoresManager{
    private const val PREFS_NAME = "high_scores_prefs"
    private const val SCORES_KEY = "scores"

    fun saveScore(context: Context, name: String, score: Int){
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val scores = loadScores(context).toMutableList()
        scores.add(Pair(name,score))
        scores.sortByDescending {it.second}
        val topScores = scores.take(5)

        val serializedScores = topScores.joinToString(";") {"${it.first},${it.second}"}
        sharedPreferences.edit().putString(SCORES_KEY, serializedScores).apply()
    }

    fun loadScores(context: Context): List<Pair<String, Int>>{
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val serializedScores = sharedPreferences.getString(SCORES_KEY, null)?: return emptyList()

        return serializedScores.split(";").mapNotNull {
            val parts = it.split(",")
            if(parts.size==2){
                Pair(parts[0], parts[1].toIntOrNull()?:0)
            } else null
        }
    }


}