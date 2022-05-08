package com.example.a0429test

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Process
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val imageViews = arrayOfNulls<ImageView>(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*상단 홈, 검색 이미지*/
        imageViews[0] = findViewById<View>(R.id.Top_home) as ImageView
        imageViews[1] = findViewById<View>(R.id.Top_search) as ImageView


        /* =======홈버튼========*/
        imageViews[0]!!.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) /*새로 생성 액티비티와 동일한 액티비티가 스텍에 있을경우 동일한 액티비티 위의 모든 액티비티를 종료*/
            startActivity(intent)
        }


        val btn_main1 = findViewById<View>(R.id.btn_main1) as Button
        btn_main1.setOnClickListener {
            val intent = Intent(applicationContext, Menu1Activity::class.java)
            startActivity(intent)
        }
        val btn_main2 = findViewById<View>(R.id.btn_main2) as Button
        btn_main2.setOnClickListener {
            val intent = Intent(applicationContext, Menu2Activity::class.java)
            startActivity(intent)
        }
    }

    /*뒤로가기 버튼 클릭시 종료 묻기*/
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("알림")
        builder.setMessage("앱을 종료하시겠습니까?")
        builder.setNegativeButton("취소", null)
        builder.setPositiveButton(
            "종료"
        ) { dialogInterface, i -> Process.killProcess(Process.myPid()) }
        builder.show()
    }

}