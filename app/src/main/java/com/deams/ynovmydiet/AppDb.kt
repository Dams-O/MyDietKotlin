package com.deams.ynovmydiet

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [(Meal::class)], version = 1)
abstract class AppDb : RoomDatabase(){
    abstract fun mealDao(): MealDAO
}