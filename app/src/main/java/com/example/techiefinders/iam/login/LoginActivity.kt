package com.example.techiefinders.iam.login

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.example.techiefinders.R
import com.example.techiefinders.iam.register.RegisterActivity
import com.example.techiefinders.landingActivity.ui.activity.MainActivity

import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        link_signup.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
        btn_login.setOnClickListener {
            var intent: Intent = Intent(this@LoginActivity, MainActivity::class.java)
            intent.putExtra("isFirstTime", false)
            startActivity(intent)
        }

    }

}
