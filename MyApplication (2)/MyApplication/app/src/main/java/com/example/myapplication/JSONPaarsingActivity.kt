package com.example.myapplication

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.databinding.ActivityJsonpaarsingBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_jsonpaarsing.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class JSONPaarsingActivity : AppCompatActivity() {

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    lateinit var abc: ActivityJsonpaarsingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        abc = ActivityJsonpaarsingBinding.inflate(layoutInflater)
        setContentView(abc.root)

        var showMondayList : ArrayList<HashMap<String, String>>
        var MondayArray : ArrayList<Monday> = ArrayList()
        var showTuesdayList : ArrayList<HashMap<String, String>>
//        var showWednesdayList : ArrayList<HashMap<String, String>>
//        var showThursdayList : ArrayList<HashMap<String, String>>

        var showAllHashmap : HashMap<String, ArrayList<String>>

        var retrofit = Retrofit.Builder()
            .baseUrl("https://fcm.live/webservice/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();  // Part 1

        val api = retrofit.create(ApiInterface::class.java); //Part 2

        api.schedulepage().enqueue(object : Callback<ScheduleModel> {
            override fun onResponse(
                call: Call<ScheduleModel>?,
                response: Response<ScheduleModel>?
            ) {
                if (response != null) {
                    Log.v("DS",""+response.body().all_shows.Monday)
                    var size = response.body().all_shows.Monday.size
                    for (i in 0..size-1) {
                        MondayArray.add(response.body().all_shows.Monday.get(i))
                    }

                    abc.listView.adapter = CustomListAdapter(this@JSONPaarsingActivity, MondayArray)
                }
            }

            override fun onFailure(call: Call<ScheduleModel>?, t: Throwable?) {
                if (t != null) {
                    Log.v("DS",""+t.message.toString())
                }
            }

        })





    }

    /*private fun getShowList() {
        val retrofit : RetrofitClient.
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getAllUsers()
                if (response.isSuccessful()) {
                    //your code for handaling success response


                } else {
                    Toast.makeText(
                        this@JSONPaarsingActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }*/

}
