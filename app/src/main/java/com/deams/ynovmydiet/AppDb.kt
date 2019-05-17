package com.deams.ynovmydiet

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [(Meal::class),(MenuType::class),(Food::class),(User::class)], version = 2)
abstract class AppDb : RoomDatabase(){
    abstract fun mealDao(): MealDAO
    abstract fun menuTypeDao(): MenuTypeDAO
    abstract fun foodDao(): FoodDAO
    abstract fun userDao(): UserDAO
}