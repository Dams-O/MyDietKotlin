package com.deams.ynovmydiet

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface MealDAO {

    @Insert
    fun saveMeal(meal : Meal)
}