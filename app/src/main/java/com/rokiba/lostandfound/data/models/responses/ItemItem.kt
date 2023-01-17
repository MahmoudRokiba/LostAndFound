package com.rokiba.lostandfound.data.models.responses

import com.google.gson.annotations.SerializedName

data class ItemItem(

	@field:SerializedName("amount")
	var amount: String = "",

	@field:SerializedName("color")
	var color: String = "",

	@field:SerializedName("name")
	var name: String = "",

	@field:SerializedName("description")
	var description: String = "",

	@field:SerializedName("location")
	var location: String = "",

	@field:SerializedName("category")
	var category: String = "",

	@field:SerializedName("lost")
	var lost: Boolean = false,

	@field:SerializedName("phone")
	var phone: String = "",

	@field:SerializedName("userName")
	var userName: String = ""

)
