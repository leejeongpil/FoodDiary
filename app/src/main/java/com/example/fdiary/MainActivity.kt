package com.example.fdiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fdiary.UserInfo.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()



        click_me_login.setOnClickListener {
            if(auth.currentUser == null){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "이미 로그인 돼 있습니다.", Toast.LENGTH_LONG).show()
            }

        }
        click_me_logout.setOnClickListener {
            Toast.makeText(this, "로그아웃 했습니다.", Toast.LENGTH_LONG).show()
            FirebaseAuth.getInstance().signOut()
        }
    }
}
