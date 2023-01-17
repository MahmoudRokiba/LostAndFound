package com.rokiba.lostandfound.data.models.responses

import com.google.gson.annotations.SerializedName

data class ItemRequest(

	@field:SerializedName("item")
	var item: ItemItem = ItemItem(),

	@field:SerializedName("rPhone")
	var rPhone: String = "",

	@field:SerializedName("rUserName")
	var rUserName: String = ""

)
