package com.example.models

import com.example.RV.PostInfo

object CommunityList {
    val communityList = listOf<PostInfo>(
        PostInfo(_title = "안녕하세요", _content = "반갑습니다"),
        PostInfo(_title = "도와주세요", _content = "help me")
         //CData(title = "안녕하세요", content = "반갑습니다"),
        //Data(title = "도와주세요", content = "help me"),
        //CData(title = "교통사고 관련 질문입니다", content = "요식업 자영업자로 간이사업자인데 10월2일 새벽 5시경 오토바이로 퇴근하다 가게 잠시 들릴일이 생겨 돌아가던중")
    )
}