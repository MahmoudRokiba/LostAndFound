package com.rokiba.lostandfound.extenstion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Html
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.utils.SpacesItemDecoration
import com.bumptech.glide.Glide

fun Activity.openActivity(targetActivity: Class<*>?, bundle: Bundle?, finish: Boolean) {
    if (finish) this.finish()
    val intent = Intent(this, targetActivity)
    if (bundle != null) intent.putExtras(bundle)
    this.startActivity(intent)
}

fun Activity.encodeHtml(message: String): String {
    return Html.fromHtml(message).toString()
}

fun Activity.showToastLong(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun Activity.setImage(view: ImageView, image: String, activity: Activity){
    Glide.with(view).load(image).into(view)
    activity.showView(view)
}

fun Activity.setImage(view: ImageView, image: String) = Glide.with(view).load(image).into(view)

fun Activity.showToastShort(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Activity.logError(message: String) = Log.wtf("BAKAR Error", message)

fun Activity.hideView(view: View) {
    view.visibility = View.GONE
}

fun Activity.invisibleView(view: View) {
    view.visibility = View.INVISIBLE
}

fun Activity.showView(view: View) {
    view.visibility = View.VISIBLE
}

fun Activity.hideFirstShowSecond(view1: View, view2: View) {
    view1.visibility = View.GONE
    view2.visibility = View.VISIBLE
}

fun Activity.initVerticalRV(
    recyclerView: RecyclerView,
    spanCount: Int,
    space: Int
): GridLayoutManager {
    val gridLayoutManager = GridLayoutManager(this, spanCount, RecyclerView.VERTICAL, false)
    recyclerView.layoutManager = gridLayoutManager
    recyclerView.addItemDecoration(SpacesItemDecoration(space, spanCount, true))
    recyclerView.isNestedScrollingEnabled = false
    return gridLayoutManager
}

fun Activity.initHorizontalRV(
    recyclerView: RecyclerView,
    spanCount: Int,
    space: Int
): GridLayoutManager {
    val gridLayoutManager = GridLayoutManager(this, spanCount, RecyclerView.HORIZONTAL, false)
    recyclerView.layoutManager = gridLayoutManager
    recyclerView.addItemDecoration(SpacesItemDecoration(space, spanCount, false))
    recyclerView.isNestedScrollingEnabled = false
    return gridLayoutManager
}

fun Activity.fillSpinner(spinner: Spinner, list: ArrayList<*>?) {
    val arrayAdapter: ArrayAdapter<*> =
        ArrayAdapter(this, R.layout.item_spinner, list as MutableList<Any>)
    arrayAdapter.setDropDownViewResource(R.layout.item_spinner_selected)
    spinner.adapter = arrayAdapter
}

fun Activity.whiteStatusBarColors() {
    window.statusBarColor = resources.getColor(R.color.white)
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}

fun Activity.setStatusBarColored(@ColorRes color: Int) {
    val window: Window = this.window
    //val background = getDrawable(R.drawable.horizontal_gradient)
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = getColor(color)
    window.decorView.systemUiVisibility = 0
    //window.navigationBarColor = getColor(android.R.color.transparent)
    //window.setBackgroundDrawable(background)
}

fun startTimer(seconds: Long, textCounter: TextView, view: View) {
    view.alpha = 0.5f
    view.isClickable = false
    object : CountDownTimer(seconds * 1000, 1000) {

        override fun onTick(millisUntilFinished: Long) {
            textCounter.text = "" + millisUntilFinished / 1000
            // logic to set the EditText could go here
        }

        override fun onFinish() {
            textCounter.text = "0"
            view.alpha = 1.0f
            view.isClickable = true
        }

    }.start()
}
