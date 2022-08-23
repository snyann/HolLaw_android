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
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.*

class RV_MainActivity : AppCompatActivity() {
    private var adapter: RecyclerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        data
    }

    private fun init() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
    }// 각 List의 값들을 data 객체에 set 해줍니다.

    // 각 값이 들어간 data를 adapter에 추가합니다.

    // adapter의 값이 변경되었다는 것을 알려줍니다.
    // 임의의 데이터입니다.
    private val data: Unit
        private get() {
            // 임의의 데이터입니다.
            val listTitle = Arrays.asList("국화")
            val listContent = Arrays.asList(
                "이 꽃은 국화입니다."
            )
            for (i in listTitle.indices) {
                // 각 List의 값들을 data 객체에 set 해줍니다.
                val data = Data()
                data.title = listTitle[i]
                data.content = listContent[i]

                // 각 값이 들어간 data를 adapter에 추가합니다.
                adapter!!.addItem(data)
            }

            // adapter의 값이 변경되었다는 것을 알려줍니다.
            adapter!!.notifyDataSetChanged()
        }
}