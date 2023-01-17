package com.rokiba.lostandfound.ui.main.admin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.data.models.responses.ItemRequest
import com.rokiba.lostandfound.databinding.ActivityAdminBinding
import com.rokiba.lostandfound.extenstion.*
import com.rokiba.lostandfound.ui.base.BaseActivity
import com.rokiba.lostandfound.ui.main.postdetails.PostDetailsActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AdminActivity :
    BaseActivity<AdminViewModel, ActivityAdminBinding>(AdminViewModel::class.java), AdminView {

    private val adapter by lazy {
        RequestsAdapter(this, viewModel, this)
    }

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.activity_admin

    override fun init(savedInstanceState: Bundle?) {
        initVerticalRV(dataBinding.recyclerView, 1, 0)
        dataBinding.recyclerView.adapter = adapter
        val arr = ArrayList<ItemRequest>()
        val database = Firebase.database
        val myRef = database.getReference("requests")
        val query = myRef.orderByKey().get().addOnSuccessListener {
            try {
                logError(it.toString())
                it.children.forEach {
                    val item = it.getValue(ItemRequest::class.java)!!
                    arr.add(item)
                    //arr.add(it.getValue(ItemItem::class.java)!!)
                }
                adapter.setItems(arr)
            } catch (e: Exception) {

            }
        }.addOnFailureListener {

        }
        dataBinding.btnClose.setOnClickListener {
            hideView(dataBinding.layoutActions)
        }
        dataBinding.btnOpenItem.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("data", Gson().toJson(item!!.item))
            openActivity(PostDetailsActivity::class.java, bundle, false)
        }
        dataBinding.btnCallPoster.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + item!!.item.phone)
            startActivity(intent)
        }
        dataBinding.btnCallRequester.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + item!!.rPhone)
            startActivity(intent)
        }
    }

    var item: ItemRequest? = null

    override fun onRequestClicked(item: ItemRequest) {
        this.item = item
        showView(dataBinding.layoutActions)
    }
}