package com.example.RV

import java.lang.reflect.Array.set
import java.nio.file.Paths.get

class PostInfo (
    _title: String?,
    _content: String?,
    _category: Boolean?,
)
{
    var title:String? = _title
        get() = field
        set(value){
            field = value
        }

    var content:String? = _content
        get() = field
        set(value){
            field = value
        }

    var category: Boolean? = _category
        get() = field
        set(value) {
            field = value
        }
}