package com.example.RV

import androidx.recyclerview.widget.RecyclerView
import com.example.RV.RecyclerAdapter.ItemViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.community.R
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.RV.RecyclerAdapter
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.ArrayList

class RecyclerAdapter : RecyclerView.Adapter<ItemViewHolder>() {
    private val listData = ArrayList<Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_recent, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData[position])
    }

    override fun getItemCount(): Int {
        // RecyclerView의 총 개수 입니다.
        return listData.size
    }

    fun addItem(data: Data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data)
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView
        private val textView2: TextView
        fun onBind(data: Data) {
            textView.text = data.title
            textView2.text = data.content
        }

        init {
            textView = itemView.findViewById(R.id.textView)
            textView2 = itemView.findViewById(R.id.textView2)
        }
    }
}