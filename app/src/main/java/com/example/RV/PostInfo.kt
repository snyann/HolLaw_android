package com.example.RV


class PostInfo (
    var _title: String?,
    var _content: String?,

)
{   var title: String? = _title
    get() = field
    set(value) {
        field = value
    }
    var content: String? = _content
        get() = field
        set(value) {
            field = value
        }
}