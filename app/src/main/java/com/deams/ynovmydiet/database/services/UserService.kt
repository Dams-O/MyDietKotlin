package com.deams.ynovmydiet.database.services

import com.deams.ynovmydiet.database.entities.User
import com.google.gson.JsonObject
import retrofit2.Call
import okhttp3.ResponseBody
import retrofit2.http.*
import java.util.*

interface UserService {
    @GET("/api/getAllUsers")
    fun listUsers(): Call<List<User>>

    @FormUrlEncoded
    @POST("/api/getUser")
    fun loginUser(@Field("mail") mail:String, @Field("password") password:String):Call<User>

    @FormUrlEncoded
    @POST("/api/createUser")
    fun createUser(
                   @Field("first_name") first_name:String,
                   @Field("pseudo") pseudo:String,
                   @Field("mail") mail:String,
                   @Field("password") password:String): Call<ResponseBody>

    @Headers("Content-Type: application/json")
    @POST("/api/createDataUser")
    fun createDataUser(@Body body: JsonObject): Call<Void>
}