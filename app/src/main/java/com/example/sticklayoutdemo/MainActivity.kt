package com.example.sticklayoutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var mTabLayout: TabLayout
    var mViewPager: ViewPager? = null
    var mPagerAdapter:MyPagerAdapter? = null

    val mFragmentList: ArrayList<Fragment> = ArrayList()
    var mTitleList:MutableList<String> =  mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTabLayout = findViewById(R.id.tab_layout)
        mViewPager = findViewById(R.id.view_pager)

        mTitleList.apply {
            add("官方")
            add("爆品")
        }

        mTitleList.forEach {
            mTabLayout.addTab(mTabLayout.newTab().setText(it))
        }

        mFragmentList.add(OfficeFragment())
        mFragmentList.add(HotFragment())


        mPagerAdapter =MyPagerAdapter(supportFragmentManager,mFragmentList,mTitleList)

        mViewPager?.adapter = mPagerAdapter
        mTabLayout.setupWithViewPager(mViewPager, false)

    }


    class MyPagerAdapter(fm: FragmentManager,var list: MutableList<Fragment>,var titleList:MutableList<String>) : FragmentPagerAdapter(fm) {

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