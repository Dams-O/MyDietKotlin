package com.deams.ynovmydiet.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class User {

    @PrimaryKey
    var id_user: Long? = null

    @ColumnInfo(name = "pseudo")
    var pseudo: String? = null

    @ColumnInfo(name = "first_name")
    var first_name: String? = null

    @ColumnInfo(name = "last_name")
    var last_name: String? = null

    @ColumnInfo(name = "brithday")
    var birthday: String? = null

    @ColumnInfo(name = "mail")
    var mail: String? = null

    @ColumnInfo(name = "password")
    var password: String? = null

    @ColumnInfo(name = "created_at")
    var created_at: String? = null

    @ColumnInfo(name = "updated_at")
    var updated_at: String? = null

}