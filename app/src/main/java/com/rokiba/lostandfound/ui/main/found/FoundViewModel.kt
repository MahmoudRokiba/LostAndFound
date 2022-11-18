package com.rokiba.lostandfound.ui.main.found

import com.rokiba.lostandfound.MyApp
import com.rokiba.lostandfound.data.Repository
import com.rokiba.lostandfound.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Mahmoud Rokiba
 * Created 11/15/2022 at 10:29 PM
 */
@HiltViewModel
class FoundViewModel @Inject constructor(private val repository: Repository, app: MyApp) :
    BaseViewModel(app) {
}