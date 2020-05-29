package com.deams.ynovmydiet.database.services

import com.deams.ynovmydiet.database.entities.Food
import com.deams.ynovmydiet.database.entities.User
import com.google.gson.JsonObject
import retrofit2.Call
import okhttp3.ResponseBody
import retrofit2.http.*
import java.util.*
import kotlin.collections.ArrayList

interface UserService {
    @GET("/api/getAllUsers")
    fun listUsers(): Call<List<User>>

    @GET("/api/getAllFoods")
    fun listFoods(): Call<List<Food>>

    @FormUrlEncoded
    @POST("/api/getUser")
    fun loginUser(@Field("mail") mail:String, @Field("password") password:String):Call<User>

    @FormUrlEncoded
    @POST("/api/createUser")
    fun createUser(
                   @Field("firstname") firstname:String,
                   @Field("pseudo") pseudo:String,
                   @Field("mail") mail:String,
                   @Field("password") password:String): Call<ResponseBody>

    @FormUrlEncoded
    @POST("/api/createDataUser")
    fun createDataUser(
        @Field("iduser") iduser:Long,
        @Field("idmealcategory") idmealcategory:String,
        @Field("id_food") id_food:Array<Int>,
        @Field("date") date:String
    ): Call<ResponseBody>
}