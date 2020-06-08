package com.example.fdiary.UserInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fdiary.MainActivity
import com.example.fdiary.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_signup_info.*

class SignupInfoActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_info)

        auth = FirebaseAuth.getInstance()

        signup_info_complete_button.setOnClickListener {
            val user = hashMapOf(
                "nickname" to signup_info_nickname_area.text.toString()
            )
            db.collection("users").document(auth.currentUser?.uid.toString())
                .set(user)
                .addOnSuccessListener {
                    Log.d("SignupInfoActivity", "Success")

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener {
                    Log.d("SignupInfoActivity", "Failure")
                }
        }
    }
}
