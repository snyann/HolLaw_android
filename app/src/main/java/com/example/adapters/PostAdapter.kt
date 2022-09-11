package com.example.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.community.R
import com.example.models.PostList

class PostAdapter(val itemList: ArrayList<PostList>): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_community,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_titlelist)
        val content: TextView = itemView.findViewById(R.id.tv_content)
    }
}