package com.rokiba.lostandfound.ui.main.addpost

import android.os.Bundle
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.ActivityAddPostBinding
import com.rokiba.lostandfound.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddPostActivity :
    BaseActivity<AddPostViewModel, ActivityAddPostBinding>(AddPostViewModel::class.java) {

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.activity_add_post

    override fun init(savedInstanceState: Bundle?) {

    }

}