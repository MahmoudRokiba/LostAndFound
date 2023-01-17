package com.rokiba.lostandfound.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.FragmentHomeBinding
import com.rokiba.lostandfound.extenstion.openActivity
import com.rokiba.lostandfound.ui.base.BaseFragment
import com.rokiba.lostandfound.ui.main.addpost.AddPostActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(HomeViewModel::class.java) {

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.fragment_home

    override fun init(view: View, savedInstanceState: Bundle?) {
        dataBinding.btnFoundItem.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("isLost", false)
            requireActivity().openActivity(AddPostActivity::class.java, bundle, false)
        }
        dataBinding.btnLostItem.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("isLost", true)
            requireActivity().openActivity(AddPostActivity::class.java, bundle, false)
        }
    }
}