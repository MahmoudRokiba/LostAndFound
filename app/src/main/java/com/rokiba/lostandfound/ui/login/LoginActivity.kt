package com.rokiba.lostandfound.ui.login

import android.os.Bundle
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.ActivityLoginBinding
import com.rokiba.lostandfound.extenstion.openActivity
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
            openActivity(MainActivity::class.java, null, true)
        }
        dataBinding.btnRegister.setOnClickListener {
            openActivity(RegisterActivity::class.java, null, false)
        }
    }
}