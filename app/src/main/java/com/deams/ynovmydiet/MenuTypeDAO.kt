package com.deams.ynovmydiet

import androidx.room.*


@Dao
interface MenuTypeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMenuType(menuType: MenuType): Long?

    @Query("SELECT * from MenuType")
    fun getAllMenuType(): List<User>

    @Query("SELECT * FROM MenuType WHERE menuTypeId = :menuTypeId LIMIT 1")
    fun findMenuTypeById(menuTypeId: Long?): Food

    fun updateMenuType(menuType: MenuType): Int

    @Delete
    fun deleteMenuType(menuType: MenuType): Int

}