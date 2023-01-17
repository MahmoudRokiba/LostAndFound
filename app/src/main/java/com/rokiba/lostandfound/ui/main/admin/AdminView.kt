package com.rokiba.lostandfound.ui.main.admin

import com.rokiba.lostandfound.data.models.responses.ItemRequest

interface AdminView {
    fun onRequestClicked(item: ItemRequest)
}