package com.deams.ynovmydiet

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room


class MenuTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_type)

        val menuType = MenuType()
        menuType.userId = 1

        var arrBreakfast = arrayOf(1, 5 ,4 ,8, 7, 2)
        menuType.breakfast = arrBreakfast

        var arrLunch = arrayOf(2, 4 ,1 , 6, 1, 5)
        menuType.lunch = arrLunch

        var arrDinner = arrayOf(4, 1 ,2 , 7, 2, 3)
        menuType.dinner = arrDinner

        var arrComplement = arrayOf(3, 7 , 4, 7, 6, 1)
        menuType.complement = arrComplement

        menuType.hasComplement = true

        val db = Room.databaseBuilder(
            applicationContext,
            AppDb::class.java,
            "mydietDb0"
        ).allowMainThreadQueries().build()

        db.menuTypeDao().insertMenuType(menuType)
        var menus = db.menuTypeDao().getAllMenuType()

        for (m in menus)
            println(m.breakfast)
    }
}