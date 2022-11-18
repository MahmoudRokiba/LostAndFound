package com.rokiba.lostandfound.ui.main.profile

import android.os.Bundle
import android.view.View
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.FragmentProfileBinding
import com.rokiba.lostandfound.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Mahmoud Rokiba
 * Created 11/15/2022 at 11:13 PM
 */
@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<ProfileViewModel, FragmentProfileBinding>(ProfileViewModel::class.java) {

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.fragment_profile

    override fun init(view: View, savedInstanceState: Bundle?) {

    }

}