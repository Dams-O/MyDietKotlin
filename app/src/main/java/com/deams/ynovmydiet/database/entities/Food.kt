package com.deams.ynovmydiet.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Food {
    @PrimaryKey
    var foodId: Long? = null

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "family")
    var family: String? = null

}