package com.rokiba.lostandfound.ui.register

import com.rokiba.lostandfound.MyApp
import com.rokiba.lostandfound.data.Repository
import com.rokiba.lostandfound.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Mahmoud Rokiba
 * Created 11/15/2022 at 9:32 PM
 */
@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: Repository, app: MyApp) :
    BaseViewModel(app) {
}