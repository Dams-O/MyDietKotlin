package com.deams.ynovmydiet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FoodAsMeal {

    @PrimaryKey
    var famId: Long? = null

    @ColumnInfo(name = "foodId")
    var foodId: Long? = null

    @ColumnInfo(name = "mealId")
    var mealId: Long? = null
}
