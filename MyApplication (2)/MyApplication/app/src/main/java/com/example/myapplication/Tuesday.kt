package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class Tuesday(
    @SerializedName("schedule_id"      ) var scheduleId    : String? = null,
    @SerializedName("show_title"       ) var showTitle     : String? = null,
    @SerializedName("image"            ) var image         : String? = null,
    @SerializedName("dj_name"          ) var djName        : String? = null,
    @SerializedName("start_time"       ) var startTime     : String? = null,
    @SerializedName("end_time"         ) var endTime       : String? = null,
    @SerializedName("description"      ) var description   : String? = null,
    @SerializedName("dj_id"            ) var djId          : String? = null,
    @SerializedName("track_list"       ) var trackList     : String? = null,
    @SerializedName("tune_of_the_week" ) var tuneOfTheWeek : String? = null,
    @SerializedName("show_modal"       ) var showModal     : String? = null

)
