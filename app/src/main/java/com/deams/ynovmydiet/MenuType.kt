package com.deams.ynovmydiet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MenuType {

    @PrimaryKey
    var menuTypeId: Long? = null

    @ColumnInfo(name = "user_id")
    var userId: Long? = null

    @ColumnInfo(name = "breakfast")
    var breakfast: Array<Int>? = null

    @ColumnInfo(name = "lunch")
    var lunch: Array<Int>? = null

    @ColumnInfo(name = "dinner")
    var dinner: Array<Int>? = null

    @ColumnInfo(name = "has_complement")
    var hasComplement: Boolean? = null

    @ColumnInfo(name = "complement")
    var complement: Array<Int>? = null
}