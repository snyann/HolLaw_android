package com.example.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.RV.Data
import com.example.community.databinding.ItemKeywordBinding

class PrecedentAdapter(val PrecendentList: List<Data>):RecyclerView.Adapter<PrecedentAdapter. PrecendentViewHolder>() {
    inner class  PrecendentViewHolder(val itemBinding: ItemKeywordBinding)
        : RecyclerView.ViewHolder(itemBinding.root){
            fun bindItem(data: Data){
                itemBinding.textView.text = data.title
                itemBinding.textView2.text = data.content

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  PrecendentViewHolder {
        return  PrecendentViewHolder(ItemKeywordBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder:  PrecendentViewHolder, position: Int) {
        val data =  PrecendentList[position]
        holder.bindItem(data)
    }

    override fun getItemCount(): Int {
        return  PrecendentList.size
    }
}
