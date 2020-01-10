package com.deams.ynovmydiet.database.dao

import androidx.room.*
import com.deams.ynovmydiet.database.entities.User
import retrofit2.Call
import retrofit2.http.GET


@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User): Long?

    @Query("SELECT * from User")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM User WHERE id_user = :id_user LIMIT 1")
    fun findUserById(id_user: Long?): User

    @Update
    fun updateUser(user: User): Int

    @Delete
    fun deleteUser(user: User): Int

}