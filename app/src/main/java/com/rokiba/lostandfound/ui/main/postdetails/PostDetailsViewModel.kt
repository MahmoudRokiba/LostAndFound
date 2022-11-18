package com.rokiba.lostandfound.ui.main.postdetails

import com.rokiba.lostandfound.MyApp
import com.rokiba.lostandfound.data.Repository
import com.rokiba.lostandfound.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Mahmoud Rokiba
 * Created 11/18/2022 at 8:30 PM
 */
@HiltViewModel
class PostDetailsViewModel @Inject constructor(private val repository: Repository, app: MyApp) :
    BaseViewModel(app) {



}