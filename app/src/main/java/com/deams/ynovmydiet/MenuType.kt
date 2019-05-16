package com.deams.ynovmydiet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MenuType {

    @PrimaryKey
    var menuTypeId: Long? = null

    @ColumnInfo(name = "user_id")
    var userId: String? = null

    @ColumnInfo(name = "breakfast")
    var breakfast: Array<String>? = null

    @ColumnInfo(name = "lunch")
    var lunch: Array<String>? = null

    @ColumnInfo(name = "dinner")
    var dinner: Array<String>? = null

    @ColumnInfo(name = "has_complement")
    var hasComplement: Boolean? = null

    @ColumnInfo(name = "complement")
    var complement: Array<String>? = null
}