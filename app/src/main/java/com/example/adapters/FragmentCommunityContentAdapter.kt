package com.example.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.RV.CommentData
import com.example.community.databinding.ItemCommentBinding

class FragmentCommunityContentAdapter(val CommentList: List<CommentData>): RecyclerView.Adapter<FragmentCommunityContentAdapter. FragmentCommunityContentViewHolder>() {
    inner class  FragmentCommunityContentViewHolder(val itemBinding: ItemCommentBinding)
        : RecyclerView.ViewHolder(itemBinding.root){
            fun bindItem(data: CommentData){
                itemBinding.commentContent.text = data.content
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentCommunityContentViewHolder {
        return  FragmentCommunityContentViewHolder(ItemCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FragmentCommunityContentViewHolder, position: Int) {
        val data =  CommentList[position]
        holder.bindItem(data)
    }

    override fun getItemCount(): Int {
        return CommentList.size
    }
}