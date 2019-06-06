package com.deams.ynovmydiet.database.dao

import androidx.room.*
import com.deams.ynovmydiet.database.entities.User


@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User): Long?

    @Query("SELECT * from User")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM User WHERE userId = :userId LIMIT 1")
    fun findUserById(userId: Long?): User

    @Update
    fun updateUser(user: User): Int

    @Delete
    fun deleteUser(user: User): Int

}