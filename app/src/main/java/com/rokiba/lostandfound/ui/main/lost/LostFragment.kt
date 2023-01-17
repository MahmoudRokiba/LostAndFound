package com.rokiba.lostandfound.ui.main.lost

import android.os.Bundle
import android.view.View
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.data.models.responses.ItemItem
import com.rokiba.lostandfound.databinding.FragmentLostBinding
import com.rokiba.lostandfound.extenstion.*
import com.rokiba.lostandfound.ui.base.BaseActivity
import com.rokiba.lostandfound.ui.base.BaseFragment
import com.rokiba.lostandfound.ui.main.MainActivity
import com.rokiba.lostandfound.ui.main.postdetails.PostDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LostFragment : BaseFragment<LostViewModel, FragmentLostBinding>(LostViewModel::class.java) {

    private val adapter by lazy {
        ItemsAdapter(requireActivity() as BaseActivity<*, *>, viewModel)
    }

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.fragment_lost

    override fun init(view: View, savedInstanceState: Bundle?) {

        requireActivity().initVerticalRV(dataBinding.recyclerView, 1, 0)
        dataBinding.recyclerView.adapter = adapter
        val arr = ArrayList<ItemItem>()
        val database = Firebase.database
        val myRef = database.getReference("items")
        val query = myRef.orderByKey().get().addOnSuccessListener {
            try {
                requireActivity().logError(it.toString())
                it.children.forEach {
                    val item = it.getValue(ItemItem::class.java)!!
                    requireActivity().logError(item.name + " " + item.lost.toString())
                    if (item.lost){
                        arr.add(item)
                    }
                    //arr.add(it.getValue(ItemItem::class.java)!!)
                }
                adapter.setItems(arr)
            } catch (e: Exception) {

            }
        }.addOnFailureListener {

        }

//        dataBinding.btnCard2.setOnClickListener {
//            requireActivity().openActivity(PostDetailsActivity::class.java, null, false)
//        }
    }

}