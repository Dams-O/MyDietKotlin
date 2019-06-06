package com.deams.ynovmydiet.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.deams.ynovmydiet.database.dao.FoodDAO
import com.deams.ynovmydiet.database.dao.MealDAO
import com.deams.ynovmydiet.database.dao.MenuTypeDAO
import com.deams.ynovmydiet.database.dao.UserDAO
import com.deams.ynovmydiet.database.entities.Food
import com.deams.ynovmydiet.database.entities.Meal
import com.deams.ynovmydiet.database.entities.MenuType
import com.deams.ynovmydiet.database.entities.User


@Database(entities = [(Meal::class),(MenuType::class),(Food::class),(User::class)], version = 1_3)
abstract class AppDb : RoomDatabase(){
    abstract fun mealDao(): MealDAO
    abstract fun menuTypeDao(): MenuTypeDAO
    abstract fun foodDao(): FoodDAO
    abstract fun userDao(): UserDAO


    companion object {

        /**
         * The only instance
         */
        private var sInstance: AppDb? = null

        /**
         * Gets the singleton instance of SampleDatabase.
         *
         * @param context The context.
         * @return The singleton instance of SampleDatabase.
         */
        @Synchronized
        fun getInstance(context: Context): AppDb {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context.applicationContext, AppDb::class.java, "mydietDb0")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return sInstance!!
        }
    }
}