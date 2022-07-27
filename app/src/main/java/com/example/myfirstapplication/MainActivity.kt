package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.io.print

class MainActivity : AppCompatActivity() {

    private var Name =""
    private var Surname =""
    private var layoutManager: LinearLayoutManager? = null
    lateinit var abc: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        abc = ActivityMainBinding.inflate(layoutInflater)
        setContentView(abc.root)

        var name1 = ArrayList<String>()
        name1.add("AAA")
        name1.add("BBB")
        name1.add("CCC")
        name1.add("DDD")
        name1.add("EEE")
        name1.add("FFF")
        name1.add("GGG")
        name1.add("HHH")
        name1.add("III")
        name1.add("JJJ")

        recylerView!!.addItemDecoration(
            EqualSpacingItemDecoration(
                this@MainActivity,
                resources.getDimension(com.intuit.sdp.R.dimen._6sdp).toInt(),
                EqualSpacingItemDecoration.VERTICAL,
                false
            )
        )

        print.setOnClickListener {
            Name = edtName.text.toString()
            Surname = edtSurname.text.toString()
            abc.nameSumationn = "Hello " + Name + " " + Surname

            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            recylerView!!.layoutManager = layoutManager
            recylerView.adapter = ResultAdapter(this@MainActivity, name1)
        }
    }
}