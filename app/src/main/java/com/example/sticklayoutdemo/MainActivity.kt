package com.example.sticklayoutdemo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    lateinit var mTabLayout: TabLayout
    var mViewPager: ViewPager? = null
    var mPagerAdapter: MyPagerAdapter? = null

    val mFragmentList: ArrayList<Fragment> = ArrayList()
    var mTitleList: MutableList<String> = mutableListOf()

    lateinit var mTvTitle:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTabLayout = findViewById(R.id.tab_layout)
        mViewPager = findViewById(R.id.view_pager)

        mTvTitle = findViewById(R.id.tv_title)

        mTitleList.apply {
            add("官方")
            add("爆品")
        }

        mTitleList.forEach {
            mTabLayout.addTab(mTabLayout.newTab().setText(it))
        }

        mFragmentList.add(OfficeFragment())
        mFragmentList.add(HotFragment())


        mPagerAdapter = MyPagerAdapter(supportFragmentManager, mFragmentList, mTitleList)

        mViewPager?.adapter = mPagerAdapter
        mTabLayout.setupWithViewPager(mViewPager, false)


        findViewById<AppBarLayout>(R.id.appbar_layout)
            .addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                Log.d(
                    "dbs",
                    "verticalOffset:${verticalOffset}"
                )

                val distance = dip2px(this, 100F)
                if (abs(verticalOffset) == distance) {
                    mTvTitle.text = "爆款"
                }else{
                    mTvTitle.text = "圈子"
                }
            })

    }

    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    class MyPagerAdapter(
        fm: FragmentManager,
        var list: MutableList<Fragment>,
        var titleList: MutableList<String>
    ) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return list[position]
        }

        override fun getCount(): Int {
            return list.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

    }
}