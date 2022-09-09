package com.example.community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.RV.PostInfo
import com.example.community.Activity.PostList
import com.example.community.databinding.ActivityCommunityBinding
import com.google.common.collect.Iterables.size
import com.google.common.collect.Iterators.size
import java.nio.file.Files.size

class PostAdapter(val itemList: ArrayList<PostList>): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_community,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }
    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {

    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_titlelist)
        val content: TextView = itemView.findViewById(R.id.tv_content)
    }
}