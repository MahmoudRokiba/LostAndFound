package com.rokiba.lostandfound.di

import android.content.Context
import com.rokiba.lostandfound.ui.base.BaseViewModel
import com.rokiba.lostandfound.MyApp
import com.rokiba.lostandfound.data.local.MyPreferences
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class])
interface AppComponent {

    fun app(): MyApp
    fun context(): Context
    fun inject(baseViewModel: BaseViewModel)
    fun getSharedPreference(): MyPreferences

}