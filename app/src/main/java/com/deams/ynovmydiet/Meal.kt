package com.deams.ynovmydiet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Meal {

    @PrimaryKey
    var mealId: Long? = null

    @ColumnInfo(name = "user_id")
    var userId: Long? = null

    @ColumnInfo(name = "type")
    var type: String? = null

    @ColumnInfo(name = "food")
    var food: String? = null

}