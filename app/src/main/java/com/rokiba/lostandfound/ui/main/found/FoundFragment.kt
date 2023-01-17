package com.rokiba.lostandfound.ui.main.found

import android.os.Bundle
import android.view.View
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.data.models.responses.ItemItem
import com.rokiba.lostandfound.databinding.FragmentFoundBinding
import com.rokiba.lostandfound.extenstion.initVerticalRV
import com.rokiba.lostandfound.extenstion.logError
import com.rokiba.lostandfound.ui.base.BaseActivity
import com.rokiba.lostandfound.ui.base.BaseFragment
import com.rokiba.lostandfound.ui.main.lost.ItemsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoundFragment :
    BaseFragment<FoundViewModel, FragmentFoundBinding>(FoundViewModel::class.java) {

    private val adapter by lazy {
        ItemsAdapter(requireActivity() as BaseActivity<*, *>, viewModel)
    }

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.fragment_found

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
                    if (!item.lost){
                        arr.add(item)
                    }
                    //arr.add(it.getValue(ItemItem::class.java)!!)
                }
                adapter.setItems(arr)
            } catch (e: Exception) {

            }
        }.addOnFailureListener {

        }

    }
}