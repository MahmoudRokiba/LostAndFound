package com.rokiba.lostandfound.ui.login

import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.ActivityLoginBinding
import com.rokiba.lostandfound.extenstion.*
import com.rokiba.lostandfound.ui.base.BaseActivity
import com.rokiba.lostandfound.ui.main.MainActivity
import com.rokiba.lostandfound.ui.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity :
    BaseActivity<LoginViewModel, ActivityLoginBinding>(LoginViewModel::class.java) {

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.activity_login

    override fun init(savedInstanceState: Bundle?) {
        dataBinding.btnLogin.setOnClickListener {
            if (dataBinding.edEmail.isNotEmptyEditText("invalid Phone Number") && dataBinding.edPassword.isValidPassword()) {
                val database = Firebase.database
                val myRef = database.getReference("users")
                myRef.child(dataBinding.edEmail.string()).get().addOnSuccessListener {
                    if (it.child("password").value == dataBinding.edPassword.string()){
                        myPreferences.setPhone(dataBinding.edEmail.string())
                        myPreferences.setName(it.child("fName").value.toString() + " " + it.child("lName").value.toString())
                        showToastLong("Logged in")
                        openActivity(MainActivity::class.java, null, true)
                    } else {
                        showToastLong("Invalid email or password")
                    }
                }.addOnFailureListener {
                    showToastLong("Invalid email or password")
                }
            }
        }
        dataBinding.btnRegister.setOnClickListener {
            openActivity(RegisterActivity::class.java, null, false)
        }
    }
}