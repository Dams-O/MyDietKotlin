package com.deams.ynovmydiet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class User {

    @PrimaryKey
    var userId: Long? = null

    @ColumnInfo(name = "username")
    var username: String? = null

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "lastname")
    var lastname: String? = null

    @ColumnInfo(name = "brithday")
    var birthday: String? = null

    @ColumnInfo(name = "mail")
    var mail: String? = null

    @ColumnInfo(name = "password")
    var password: String? = null

    @ColumnInfo(name = "city")
    var city: String? = null

    @ColumnInfo(name = "status")
    var status: String? = null

}