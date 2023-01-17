package com.rokiba.lostandfound.ui.main.postdetails

import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.data.models.responses.ItemItem
import com.rokiba.lostandfound.databinding.ActivityPostDetailsBinding
import com.rokiba.lostandfound.extenstion.hide
import com.rokiba.lostandfound.extenstion.showToastLong
import com.rokiba.lostandfound.extenstion.string
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
        dataBinding.btnRequestContact.setOnClickListener {

            val database = Firebase.database
            val myRef = database.getReference("requests")
            val map = mapOf(
                "rPhone" to myPreferences.getPhone(),
                "rUserName" to myPreferences.getName(),
                "item" to viewModel.item.value!!,
            )
            myRef.push().setValue(map).addOnSuccessListener {
                showToastLong("Request Sent Successfully")
                dataBinding.btnRequestContact.hide()
            }

        }
        viewModel.item.observe(this) {

        }
        try {
            viewModel.item.value = Gson().fromJson(intent.getStringExtra("data"), ItemItem::class.java)
        } catch (e: Exception) {

        }
    }
}