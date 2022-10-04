package com.example.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.RV.PostInfo
import com.example.community.databinding.ItemContentBinding


class CommunityAdapter(
    val communityList: MutableList<PostInfo>
):RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder>() {

    inner class CommunityViewHolder(val itemBinding: ItemContentBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {
            fun bindItem(data: PostInfo){
                itemBinding.tvTitlelist.text = data.title
                itemBinding.tvContent.text = data.content
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityViewHolder {
        return CommunityViewHolder(ItemContentBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        val data = communityList[position]
        holder.bindItem(data)
    }

    override fun getItemCount(): Int {
        return communityList.size
    }
    fun clearpost(){
        communityList.clear()
    }

}
