package com.example.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.RV.Data
import com.example.community.Activity.FullLawFragment
import com.example.community.Activity.FullPrecedentActivity
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

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView?.context, FullLawFragment::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return lawList.size
    }
}
