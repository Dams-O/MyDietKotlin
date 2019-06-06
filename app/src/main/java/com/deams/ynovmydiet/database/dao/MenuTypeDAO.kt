package com.deams.ynovmydiet.database.dao

import androidx.room.*
import com.deams.ynovmydiet.database.entities.MenuType


@Dao
interface MenuTypeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMenuType(menuType: MenuType): Long?

    @Query("SELECT * from MenuType")
    fun getAllMenuType(): List<MenuType>

    @Query("SELECT * FROM MenuType WHERE menuTypeId = :menuTypeId LIMIT 1")
    fun findMenuTypeById(menuTypeId: Long?): MenuType

    @Update
    fun updateMenuType(menuType: MenuType): Int

    @Delete
    fun deleteMenuType(menuType: MenuType): Int

}