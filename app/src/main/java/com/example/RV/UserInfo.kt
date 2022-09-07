package com.example.RV

class UserInfo (
    _uid: String?,
    _email: String?,
    _pwd: String?
)
{
    var uid : String? = _uid
        get() = field
        set(value){
            field = value
        }
    var email : String? = _email
        get() = field
        set(value){
            field = value
        }

    var pwd1:String? = _pwd
        get() = field
        set(value){
            field = value
        }
}
