package com.rokiba.lostandfound.extenstion

import android.app.Activity
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.rokiba.lostandfound.R
import java.io.File
import java.util.regex.Pattern

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.reverseVisibility() {
    if (isShown) {
        visibility = View.GONE
    } else {
        visibility = View.VISIBLE
    }
}

fun View.rotate180() {
    rotation = if (rotation == 0f) {
        180f
    } else {
        0f
    }
}

fun View.rotate90() {
    rotation = if (rotation == 0f) {
        90f
    } else {
        0f
    }
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun TextView.string(): String {
    return this.text.toString()
}

fun EditText.isNotEmptyEditText(errorMessage: String): Boolean {
    var s=""

    return if (this.text.toString().trim().isEmpty()) {
        this.error = errorMessage
        this.requestFocus()
        false
    } else {
        true
    }
}

fun EditText.isValidPassword(): Boolean {
    var s=""

    return if (this.text.toString().trim().isNotEmpty()) {
        true
    } else {
        this.error = "Password Should be 6 or more character"
        this.requestFocus()
        false
    }
}

fun EditText.isValidEmailAddress(): Boolean {
    var s=""

    return if (!TextUtils.isEmpty(this.text.toString()) && android.util.Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()) {
        true
    } else {
        this.error = "Invalid Email Format"
        this.requestFocus()
        false
    }
}

//fun EditText.isValidSaudiPhone(): Boolean {
//    var s=""
//
//    return if (!TextUtils.isEmpty(this.text.toString()) && Pattern.compile("(?:\\+?0*?966)?0?5[0-9]{8}").matcher("00966" + this.text.toString()).matches()) {
//        true
//    } else {
//        this.error = this.context.getString(R.string.invalid_saudi_phone)
//        this.requestFocus()
//        false
//    }
//}

fun EditText.setFocusableError(string: String) {
    this.error = string
    this.requestFocus()
}
