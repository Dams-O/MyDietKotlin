package com.deams.ynovmydiet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface MealDAO {

    @Insert
    fun saveMeal(meal : Meal)

    @Query("SELECT * from Meal")
    fun getAllMeals(): List<Meal>


}