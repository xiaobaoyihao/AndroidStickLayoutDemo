package com.example.sticklayoutdemo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class OfficeFragment : Fragment() {


    private var mRvList: RecyclerView? = null
    private var mList: MutableList<String>? = null
    private var mAdapter: MyAdapter? = null


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_office, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRvList = view.findViewById<RecyclerView>(R.id.rv_list)

        mList = mutableListOf()
        for (index in 1..40) {
            mList?.add("item $index")
        }

        mAdapter = context?.let { MyAdapter(it, mList!!) }

        mRvList?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mRvList?.adapter = mAdapter
    }

    class MyAdapter(var context: Context, var list: MutableList<String>) : RecyclerView.Adapter<MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(context).inflate(R.layout.item_fragment_office, parent, false)
//            Log.d("dbs", "===onCreateViewHolder ")
            return MyViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.tvTitle.text = list[position]
//            Log.d("dbs", "===onBindViewHolder position:${position} ")
        }

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    }
}