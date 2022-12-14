package com.rokiba.lostandfound.ui.main.postdetails

import android.os.Bundle
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.ActivityPostDetailsBinding
import com.rokiba.lostandfound.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsActivity :
    BaseActivity<PostDetailsViewModel, ActivityPostDetailsBinding>(PostDetailsViewModel::class.java) {

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.activity_post_details

    override fun init(savedInstanceState: Bundle?) {

    }
}