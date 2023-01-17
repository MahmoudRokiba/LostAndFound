package com.rokiba.lostandfound.ui.main.admin;

import com.rokiba.lostandfound.MyApp
import com.rokiba.lostandfound.data.Repository
import com.rokiba.lostandfound.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AdminViewModel @Inject constructor(private val repository: Repository, app: MyApp) :
    BaseViewModel(app) {

}