package com.rokiba.lostandfound.ui.main.lost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.rokiba.lostandfound.data.models.responses.ItemItem
import com.rokiba.lostandfound.databinding.IttemItemBinding
import com.rokiba.lostandfound.extenstion.openActivity
import com.rokiba.lostandfound.ui.base.BaseActivity
import com.rokiba.lostandfound.ui.base.BaseViewModel
import com.rokiba.lostandfound.ui.base.MyBaseAdapter
import com.rokiba.lostandfound.ui.main.postdetails.PostDetailsActivity

/**
 * @author Mahmoud Rokiba
 * Created 10/20/2022 at 1:58 PM
 */
class ItemsAdapter(
    activity: BaseActivity<*, *>?,
    viewModel: BaseViewModel
) :
    MyBaseAdapter<BaseViewModel, IttemItemBinding?, ItemItem, ItemsAdapter.ItemsViewHolder>(
        activity!!, viewModel
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        dataBinding = IttemItemBinding.inflate(layoutInflater, parent, false)
        return ItemsViewHolder(dataBinding!!)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val item: ItemItem = itemsList[position]
        holder.binding.item = item
        //activity.setImage(holder.binding.image, item.logo)
        holder.binding.root.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("data", Gson().toJson(item))
            activity.openActivity(PostDetailsActivity::class.java, bundle, false)
        }
    }

    class ItemsViewHolder(val binding: IttemItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}