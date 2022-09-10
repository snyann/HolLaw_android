package com.example.models

import com.example.RV.CData
import com.example.RV.PostInfo

object CommunityList {
    val communityList = listOf<PostInfo>(
        PostInfo(title = "안녕하세요", content = "반갑습니다",category = null),
        PostInfo(title = "도와주세요", content = "help me",category = null),
        PostInfo(title = "교통사고 관련 질문입니다", content = "요식업 자영업자로 간이사업자인데 10월2일 새벽 5시경 오토바이로 퇴근하다 가게 잠시 들릴일이 생겨 돌아가던중",category = null),
        //CData(title = "안녕하세요", content = "반갑습니다"),
        //Data(title = "도와주세요", content = "help me"),
        //CData(title = "교통사고 관련 질문입니다", content = "요식업 자영업자로 간이사업자인데 10월2일 새벽 5시경 오토바이로 퇴근하다 가게 잠시 들릴일이 생겨 돌아가던중")
    )
}