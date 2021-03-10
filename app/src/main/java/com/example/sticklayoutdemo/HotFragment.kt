package com.example.sticklayoutdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class HotFragment : Fragment() {


    lateinit var mTabLayout: TabLayout
    lateinit var mViewPager: ViewPager
    var mPagerAdapter: MainActivity.MyPagerAdapter? = null

    val mFragmentList: ArrayList<Fragment> = ArrayList()
    var mTitleList: MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTabLayout = view.findViewById(R.id.sub_tab_layout)
        mViewPager = view.findViewById(R.id.sub_view_pager)


        mTitleList.apply {
            add("sub1")
            add("sub2")
        }

        mTitleList.forEach {
            mTabLayout.addTab(mTabLayout.newTab().setText(it))
        }

        mFragmentList.add(OfficeFragment())
        mFragmentList.add(OfficeFragment())


        mPagerAdapter =
            MainActivity.MyPagerAdapter(childFragmentManager, mFragmentList, mTitleList)

        mViewPager.adapter = mPagerAdapter
        mTabLayout.setupWithViewPager(mViewPager, false)
    }
}