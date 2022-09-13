package com.example.community.Activity

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.community.R

class FullPrecedentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_full_precedent)
        val fullText: TextView = findViewById(R.id.fullText)
        val text:String = "\n[판시사항]\n" +
                "[1] 교차로에 교통섬이 설치되고 그 오른쪽으로 직진 차로에서 분리된 우회전차로가 설치되어 있는 경우, 우회전차로 아닌 직진 차로를 따라 우회전하는 행위가 구 도로교통법 제25조 제1항 에서 정한 ‘교차로 통행방법’에 위배되는지 여부(원칙적 적극)\n" +
                "\n" +
                "[2] 자동차 운전자인 피고인이, 교통섬이 설치되고 그 오른쪽으로 직진 차로에서 분리된 우회전차로가 설치되어 있는 교차로에서 우회전차로가 아닌 직진 2개 차로 중 오른쪽 차로를 따라 교차로에 진입하는 방법으로 우회전하였다고 하여 구 도로교통법 위반으로 기소된 사안에서, 피고인의 행위가 같은 법 제25조 제1항 에서 정한 ‘교차로 통행방법’에 위배되지 않는다고 본 원심판결에 법리오해의 위법이 있다고 한 사례\n" +
                "\n" +
                "[판결요지]\n" +
                "[1] 구 도로교통법(2010. 7. 23. 법률 제10382호로 개정되기 전의 것) 제25조 제1항 , 제2조 제12호 및 ‘도로의 구조·시설 기준에 관한 규칙’ 제2조 제24호 , 제43호 , 제32조 제3항 의 내용과 취지 등을 종합하면, 교통섬이 설치되고 그 오른쪽으로 직진 차로에서 분리된 우회전차로가 설치되어 있는 교차로에서 우회전을 하고자 하는 운전자는 특별한 사정이 없는 한 도로 우측 가장자리인 우회전차로를 따라 서행하면서 우회전하여야 하고, 우회전차로가 아닌 직진 차로를 따라 교차로에 진입하는 방법으로 우회전하여서는 아니된다.\n" +
                "\n" +
                "[2] 자동차 운전자인 피고인이, 교통섬이 설치되고 그 오른쪽으로 직진 차로에서 분리된 우회전차로가 설치되어 있는 교차로에서 우회전차로가 아닌 직진 2개 차로 중 오른쪽 차로를 따라 교차로에 진입하는 방법으로 우회전하였다고 하여 구 도로교통법(2010. 7. 23. 법률 제10382호로 개정되기 전의 것) 위반으로 기소된 사안에서, 위 교차로에서 우회전차로가 아닌 직진 차로의 우측 가장자리를 따라 교차로에 진입하는 방법으로 우회전할 수 있다는 전제하에 피고인의 행위가 같은 법 제25조 제1항 에서 정한 교차로 통행방법에 위배되지 않는다고 본 원심판결에 법리오해의 위법이 있다고 한 사례.\"\n" +
                "            "
        fullText.text = text
        fullText.movementMethod = ScrollingMovementMethod()

        val btn_backspace = findViewById<ImageButton>(R.id.btn_backspace)
        btn_backspace.setOnClickListener {
            val intent = Intent(applicationContext, ResultActivity::class.java)
            startActivity(intent)
        }
    }
}