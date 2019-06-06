package com.deams.ynovmydiet.database.dao

import androidx.room.*
import com.deams.ynovmydiet.database.entities.Food


@Dao
interface FoodDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFood(food: Food): Long?

    @Query("SELECT * from Food")
    fun getAllFoods(): List<Food>

    @Query("SELECT * FROM Food WHERE foodId = :foodId LIMIT 1")
    fun findFoodById(foodId: Long?): Food

    @Query("SELECT * FROM Food WHERE name = :name LIMIT 1")
    fun findFoodByName(name: String?): Food

    @Query("SELECT * FROM Food WHERE family = :family LIMIT 1")
    fun findFoodByFamily(family: String?): Food
}