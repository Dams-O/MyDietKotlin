package com.deams.ynovmydiet.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
class Meal {

    @PrimaryKey
    var mealId: Long? = null

    @ColumnInfo(name = "user_id")
    var userId: Long? = null

    @ColumnInfo(name = "moment")
    var moment: String? = null

    @ColumnInfo(name = "type")
    var type: String? = null

    @ColumnInfo(name = "food")
    var food: String? = null

}