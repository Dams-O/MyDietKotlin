package com.deams.ynovmydiet.database.dao

import androidx.room.*
import com.deams.ynovmydiet.database.entities.Meal


@Dao
interface MealDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeal(meal: Meal): Long?

    @Query("SELECT * from Meal")
    fun getAllMeals(): List<Meal>

    @Query("SELECT * FROM Meal WHERE mealId = :mealId LIMIT 1")
    fun findMealById(mealId: Long?): Meal

    @Update
    fun updateMeal(meal: Meal): Int

    @Delete
    fun deleteMeal(meal: Meal): Int
}