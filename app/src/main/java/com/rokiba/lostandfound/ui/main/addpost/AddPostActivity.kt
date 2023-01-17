package com.rokiba.lostandfound.ui.main.addpost

import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.ActivityAddPostBinding
import com.rokiba.lostandfound.extenstion.*
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
        dataBinding.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                showView(dataBinding.cardAmount)
            } else {
                hideView(dataBinding.cardAmount)
            }
        }
        dataBinding.btnSend.setOnClickListener {
            if (
                dataBinding.edName.isNotEmptyEditText("Name Required") &&
                dataBinding.edDescription.isNotEmptyEditText("Name Required")
            ) {
                val database = Firebase.database
                val myRef = database.getReference("items")
                val map = mapOf(
                    "phone" to myPreferences.getPhone(),
                    "userName" to myPreferences.getName(),
                    "name" to dataBinding.edName.string(),
                    "description" to dataBinding.edDescription.string(),
                    "category" to dataBinding.edCategory.string(),
                    "color" to dataBinding.edColor.string(),
                    "amount" to dataBinding.edAmount.string(),
                    "isLost" to intent.getBooleanExtra("isLost", false)
                )
                myRef.push().setValue(map).addOnSuccessListener {
                    showToastLong("Saved Successfully")
                    finish()
                }
            }
        }
    }

}