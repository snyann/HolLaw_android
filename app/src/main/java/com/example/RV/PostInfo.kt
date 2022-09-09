package com.example.RV

import java.lang.reflect.Array.set
import java.nio.file.Paths.get

class PostInfo (
    var title: String?,
    var content: String?,
    var category: Boolean?,
)
{
   constructor() : this("","", true)
}