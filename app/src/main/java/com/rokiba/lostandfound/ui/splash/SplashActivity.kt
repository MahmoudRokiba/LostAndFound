package com.rokiba.lostandfound.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.ActivitySplashBinding
import com.rokiba.lostandfound.extenstion.openActivity
import com.rokiba.lostandfound.ui.base.BaseActivity
import com.rokiba.lostandfound.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>(SplashViewModel::class.java) {

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.activity_splash

    override fun init(savedInstanceState: Bundle?) {

        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                openActivity(LoginActivity::class.java, null, true)
            }
        }.start()

    }
}