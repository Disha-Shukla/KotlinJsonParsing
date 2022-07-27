package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ClickInterfaace{

    private var Name =""
    private var Surname =""
    private val mDates = ArrayList<String>()
    private var layoutManager: LinearLayoutManager? = null

    private var clicked = false

    lateinit var abc: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        abc = ActivityMainBinding.inflate(layoutInflater)
       setContentView(abc.root)
        //setContentView(view)

        var name1 = ArrayList<String>()
        name1.add("AAA")
        name1.add("BBB")
        name1.add("CCC")
        name1.add("DDD")
        name1.add("EEE")
        name1.add("FFF")

        var name2 = ArrayList<String>()
        name2.add("GGG")
        name2.add("HHH")
        name2.add("III")
        name2.add("JJJ")
        name2.add("AAA")
        name2.add("BBB")
        name2.add("CCC")

        recylerView!!.addItemDecoration(
            EqualSpacingItemDecoration(
                this@MainActivity,
                resources.getDimension(R.dimen._6sdp).toInt(),
                EqualSpacingItemDecoration.VERTICAL,
                false
            )
        )

      print.setOnClickListener {
          Name = edtName.text.toString()
          Surname = edtSurname.text.toString()
          abc.nameSumationn = "Hello "+Name + " "+ Surname
          if(clicked){
              layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
              recylerView!!.layoutManager = layoutManager
              recylerView.adapter = ResultAdapter(this@MainActivity, name1, this@MainActivity)
              clicked = false
          }
          else{
              recylerView.adapter = ResultAdapter(this@MainActivity, name2, this@MainActivity)
             // recylerView.adapter!!.notifyDataSetChanged()
              clicked = true
          }
      }
    }

    override fun getSeriesId(sericeId: String) {
        Toast.makeText(this@MainActivity, sericeId, Toast.LENGTH_LONG).show()
        abc.nameSumationn = sericeId
    }
}