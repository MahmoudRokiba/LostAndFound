package com.rokiba.lostandfound.ui.register

import android.os.Bundle
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.ActivityRegisterBinding
import com.rokiba.lostandfound.extenstion.openActivity
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
            openActivity(MainActivity::class.java, null, true)
        }
    }
}