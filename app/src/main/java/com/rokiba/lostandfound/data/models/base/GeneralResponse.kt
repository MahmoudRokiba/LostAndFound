package com.rokiba.lostandfound.data.models.base

import com.google.gson.annotations.SerializedName

data class GeneralResponse<T> (
    @SerializedName("data")
    val data: T?,
    @SerializedName("msg")
    val msg: String
): BaseEntity()