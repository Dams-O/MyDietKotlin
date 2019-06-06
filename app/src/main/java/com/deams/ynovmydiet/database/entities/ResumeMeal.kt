package com.deams.ynovmydiet.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ResumeMeal {
    @PrimaryKey
    var repasId: Long? = null

    @ColumnInfo(name = "date")
    var date: String? = null

    @ColumnInfo(name = "date")
    var moment: String? = null

    @ColumnInfo(name = "aliment")
    var aliment: String? = null

    @ColumnInfo(name = "score")
    var score: String? = null

    @ColumnInfo(name = "scoreint")
    var scoreint: Int? = null


}