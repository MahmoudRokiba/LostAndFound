package com.rokiba.lostandfound.ui.main.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.FragmentProfileBinding
import com.rokiba.lostandfound.extenstion.openActivity
import com.rokiba.lostandfound.ui.base.BaseFragment
import com.rokiba.lostandfound.ui.login.LoginActivity
import com.rokiba.lostandfound.ui.main.admin.AdminActivity
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
        dataBinding.txtName.setText(myPreferences.getName())
        dataBinding.txtPhone.setText(myPreferences.getPhone())
        dataBinding.btnLogout.setOnClickListener {
            myPreferences.setName("")
            myPreferences.setPhone("")
            requireActivity().finishAffinity()
            requireActivity().openActivity(LoginActivity::class.java, null, true)
        }
        dataBinding.btnAdmin.setOnClickListener {
            requireActivity().openActivity(AdminActivity::class.java, null, false)
        }
        dataBinding.btnAboutApp.setOnClickListener {
            val url = "http://www.hti.edu.eg/en/page.aspx?id=1000"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        dataBinding.btnTerms.setOnClickListener {
            val url = "http://www.hti.edu.eg/en/news-events-announcement.aspx?id=1000"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }

}