package com.example.fdiary.UserInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.fdiary.MainActivity
import com.example.fdiary.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        login_button.setOnClickListener {
            auth.signInWithEmailAndPassword(login_email_area.text.toString(), login_password_area.text.toString())
                .addOnCompleteListener(this){task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("login", "signInWithEmail:success")
                        Toast.makeText(baseContext, "signInWithEmail", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
//                        val user = auth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.d("login", "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
//                        updateUI(null)
                        finish()
                    }
                }

        }

        login_signup_button.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
