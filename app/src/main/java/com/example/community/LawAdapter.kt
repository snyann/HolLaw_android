package com.example.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.RV.Data
import com.example.community.databinding.ItemKeywordBinding

class LawAdapter(val lawList: List<Data>):RecyclerView.Adapter<LawAdapter.LawViewHolder>() {
    inner class LawViewHolder(val itemBinding: ItemKeywordBinding)
        : RecyclerView.ViewHolder(itemBinding.root){
            fun bindItem(data: Data){
                itemBinding.textView.text = data.title
                itemBinding.textView2.text = data.content
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LawViewHolder {
        return LawViewHolder(ItemKeywordBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: LawViewHolder, position: Int) {
        val data = lawList[position]
        holder.bindItem(data)
    }

    override fun getItemCount(): Int {
        return lawList.size
    }
}
