package com.rokiba.lostandfound.ui.main.lost

import android.os.Bundle
import android.view.View
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.FragmentLostBinding
import com.rokiba.lostandfound.extenstion.openActivity
import com.rokiba.lostandfound.ui.base.BaseFragment
import com.rokiba.lostandfound.ui.main.postdetails.PostDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LostFragment : BaseFragment<LostViewModel, FragmentLostBinding>(LostViewModel::class.java) {
    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.fragment_lost

    override fun init(view: View, savedInstanceState: Bundle?) {
        dataBinding.btnCard1.setOnClickListener {
            requireActivity().openActivity(PostDetailsActivity::class.java, null, false)
        }
        dataBinding.btnCard2.setOnClickListener {
            requireActivity().openActivity(PostDetailsActivity::class.java, null, false)
        }
    }

}