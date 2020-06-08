package com.example.fdiary.UserInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fdiary.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()

        signup_signup_info_button.setOnClickListener {
            auth.createUserWithEmailAndPassword(signup_email_area.text.toString(), signup_password_area.text.toString())
                .addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        val intent = Intent(this, SignupInfoActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, "fail", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}
