package com.deams.ynovmydiet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Food {
    @PrimaryKey
    var foodId: Long? = null

    @ColumnInfo(name = "name")
    var name: Long? = null

    @ColumnInfo(name = "family")
    var family: String? = null

}