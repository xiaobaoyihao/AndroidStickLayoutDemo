package com.example.sticklayoutdemo.nestscroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sticklayoutdemo.OfficeFragment
import com.example.sticklayoutdemo.R

class NestScrollActivity: AppCompatActivity() {

    private var mRvList: RecyclerView? = null
    private lateinit var mList: MutableList<String>
    private var mAdapter: OfficeFragment.MyAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_nested_scroll)

        mRvList = findViewById(R.id.recyclerview)

        mList = mutableListOf()
        for (index in 1..40) {
            mList.add("item $index")
        }

        mAdapter = OfficeFragment.MyAdapter(this, mList)

        mRvList?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRvList?.adapter = mAdapter
    }
}