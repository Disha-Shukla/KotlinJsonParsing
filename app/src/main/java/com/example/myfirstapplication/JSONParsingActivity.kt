package com.example.myfirstapplication

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import android.util.Log
import com.example.myfirstapplication.databinding.ActivityJsonparsingBinding
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JSONParsingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJsonparsingBinding
    lateinit var progressDialog:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJsonparsingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
         progressDialog =  ProgressDialog(this@JSONParsingActivity)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Data is loading, please wait")


        webServiceCall()
        progressDialog.show()


    }

    private fun webServiceCall() {
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
                    progressDialog.dismiss()
                    Log.v("DS",""+response.body().toString())
                    var allShowModel:AllShows = response.body().all_shows;
                    setupViewPager(allShowModel)
                }
            }

            override fun onFailure(call: Call<ScheduleModel>?, t: Throwable?) {
                if (t != null) {
                    Log.v("DS",""+t.message.toString())
                }
            }

        })

    }

    private fun setupViewPager(allShowModel: AllShows) {
        val viewPager = binding.viewpager
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, allShowModel )

        val tab = binding.tabLayout
        tab!!.addTab(tab!!.newTab().setText("Monday"))
        tab!!.addTab(tab!!.newTab().setText("Tuesday"))
        tab!!.addTab(tab!!.newTab().setText("Wednesday"))
        tab!!.addTab(tab!!.newTab().setText("Thursday"))
        tab!!.addTab(tab!!.newTab().setText("Friday"))
        tab!!.addTab(tab!!.newTab().setText("Saturday"))
        tab!!.addTab(tab!!.newTab().setText("Sunday"))
        //tabLayout!!.addTab(tabLayout!!.newTab().setText("Movie"))
        tab!!.tabGravity = TabLayout.GRAVITY_FILL

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        tab!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}