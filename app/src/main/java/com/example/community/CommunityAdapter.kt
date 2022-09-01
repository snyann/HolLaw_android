package com.example.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.RV.CData
import com.example.community.databinding.ItemContentBinding

class CommunityAdapter(val communityList: List<CData>):RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder>() {
    inner class CommunityViewHolder(val itemBinding: ItemContentBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {
            fun bindItem(data: CData){
                itemBinding.tvTitlelist.text = data.title
                itemBinding.tvContent.text = data.content
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityAdapter.CommunityViewHolder {
        return CommunityViewHolder(ItemContentBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        val data = communityList[position]
        holder.bindItem(data)
    }

    override fun getItemCount(): Int {
        return communityList.size
    }
}