package com.rokiba.lostandfound.ui.register

import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.ActivityRegisterBinding
import com.rokiba.lostandfound.extenstion.openActivity
import com.rokiba.lostandfound.extenstion.showToastLong
import com.rokiba.lostandfound.extenstion.string
import com.rokiba.lostandfound.ui.base.BaseActivity
import com.rokiba.lostandfound.ui.main.MainActivity
import com.rokiba.lostandfound.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity :
    BaseActivity<RegisterViewModel, ActivityRegisterBinding>(RegisterViewModel::class.java) {

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.activity_register

    override fun init(savedInstanceState: Bundle?) {
        dataBinding.btnLogin.setOnClickListener {
            openActivity(LoginActivity::class.java, null, true)
        }
        dataBinding.btnRegister.setOnClickListener {
            // Write a message to the database
            val database = Firebase.database
            val myRef = database.getReference("users")
            val map = mapOf(
                "fName" to dataBinding.edFirstName.string(),
                "lName" to dataBinding.edLastName.string(),
                "email" to dataBinding.edEmail.string(),
                "phone" to dataBinding.edPhone.string(),
                "password" to dataBinding.edPassword.string()
            )
            myRef.child(dataBinding.edPhone.string()).setValue(map).addOnSuccessListener {
                showToastLong("Registered Successfully")
                finish()
            }
            //val user = mapOf(dataBinding.edPhone.string() to map)
            //myRef.setValue(user)
            //openActivity(MainActivity::class.java, null, true)
        }
    }
}