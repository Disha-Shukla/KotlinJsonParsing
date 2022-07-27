package com.example.myfirstapplication

import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("schedule_page")
    fun schedulepage(): Call<ScheduleModel>
}