package com.example.myapplication

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ScheduleModel(
    var all_shows: AllShows

) : Parcelable

@Parcelize

class AllShows(
    var Monday: ArrayList<Monday>,
    var Tuesday: ArrayList<Monday>,
    var Wednesday: ArrayList<Monday>,
    var Thursday: ArrayList<Monday>,
    var Friday: ArrayList<Monday>,
    var Saturday: ArrayList<Monday>,
    var Sunday: ArrayList<Monday>,

    ): Parcelable

@Parcelize
class Monday(
    var description: String,
    var dj_id: String,
    var dj_name: String,
    var end_time: String,
    var image: String,
    var schedule_id: String,
    var show_modal: String,
    var show_title: String,
    var start_time: String,
    var track_list: String,
    var tune_of_the_week: String
): Parcelable {
    fun showtime(): String{
        return start_time +" to "+ end_time
    }
}
