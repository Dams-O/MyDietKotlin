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
    var breakfast: String? = null

    @ColumnInfo(name = "lunch")
    var lunch: String? = null

    @ColumnInfo(name = "dinner")
    var dinner: String? = null

    @ColumnInfo(name = "has_complement")
    var hasComplement: Boolean? = null

    @ColumnInfo(name = "complement")
    var complement: String? = null
}