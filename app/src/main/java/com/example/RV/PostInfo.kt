package com.example.RV


class PostInfo (
    var title: String?,
    var content: String?,
    var category: Boolean?,
)
{
   constructor() : this("","", true)
}