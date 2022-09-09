package com.example.community.Activity

import com.example.RV.Data

object PostList {
    val postList = listOf<data>(
        data(title = "게시믈 제목", content = "게시물 내용", category = true) ,
        data(title = "게시믈 제목", content = "게시물 내용", category = true) ,
        data(title = "게시믈 제목", content = "게시물 내용", category = true) ,
        data(title = "게시믈 제목", content = "게시물 내용", category = true) ,
        data(title = "게시믈 제목", content = "게시물 내용", category = true) ,
        data(title = "게시믈 제목", content = "게시물 내용", category = true) ,
        data(title = "게시믈 제목", content = "게시물 내용", category = true) ,


    )

    class data (val title: String, val content:String,val category:Boolean)
}