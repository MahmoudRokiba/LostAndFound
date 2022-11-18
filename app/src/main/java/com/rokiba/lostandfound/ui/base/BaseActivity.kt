package com.rokiba.lostandfound.ui.base

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.rokiba.lostandfound.Env
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.data.local.MyPreferences
import com.rokiba.lostandfound.data.models.base.ApiResponse
import com.rokiba.lostandfound.extenstion.logError
import com.rokiba.lostandfound.extenstion.openActivity
import com.rokiba.lostandfound.extenstion.showToastLong
import com.rokiba.lostandfound.extenstion.showToastShort
import com.rokiba.lostandfound.ui.splash.SplashActivity
import com.google.gson.Gson
import com.zeugmasolutions.localehelper.LocaleAwareCompatActivity
import okio.IOException
import org.json.JSONObject
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.inject.Inject


abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding>(private val viewModelClass: Class<VM>) :
    LocaleAwareCompatActivity() {

    @Inject
    lateinit var myPreferences: MyPreferences

    @Inject
    lateinit var gson: Gson

    val viewModel by lazy {
        viewModelProvider.get(viewModelClass)
    }

    lateinit var dataBinding: DB

    private val viewModelProvider by lazy {
        ViewModelProvider(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //whiteStatusBarColors()
        dataBinding = DataBindingUtil.setContentView(this, getLayout())
        dataBinding.lifecycleOwner = this
        bindViewModel()
        basicObservers()
        init(savedInstanceState)
    }

    abstract fun bindViewModel()

    private fun basicObservers() {
        viewModel.isBackPressed.observe(this) {
            if (it) {
                viewModel.isBackPressed.value = false
                finish()
            }
        }

        viewModel.errorResponse.observe(this) {
            handleErrorResponse(it)
        }
    }

    private fun handleErrorResponse(errorResponse: ApiResponse<*>) {
        if (errorResponse.isResponseSuccessful) return

        if (errorResponse.exception != null) {
            if (errorResponse.isCanceled) return

            when (errorResponse.exception) {
                is IOException -> showToastLong(getString(R.string.error_connection))
                is IllegalStateException -> showToastLong(getString(R.string.label_json_error))
                else -> {
                    if (!Env.isProduction) showToastLong(getString(R.string.error_unknown))
                    logError(errorResponse.exception!!.message!!)
                }
            }
        } else if (!errorResponse.isResponseSuccessful) {
            when (errorResponse.responseCode) {
                500 -> showToastShort(getString(R.string.error_server_side))
                400 -> {
                    handleError400(errorResponse)
                }
                401 -> {
                    handleError401(errorResponse)
                }
                else -> {
                    try {
                        val jsonObject = JSONObject(errorResponse.errorBody!!.string())
                        showToastLong(jsonObject.optJSONArray("error")[0].toString())
                    } catch (ignored: Exception) {

                    }
                }
            }
        }
    }

    open fun handleError400(errorResponse: ApiResponse<*>) {
        try {
            val jsonObject = JSONObject(errorResponse.errorBody!!.string())
            showToastLong(jsonObject.optString("msg"))
        } catch (ignored: Exception) {

        }
    }

    open fun handleError401(errorResponse: ApiResponse<*>) {
        try {
            val jsonObject = JSONObject(errorResponse.errorBody!!.string())
            if (jsonObject.optJSONArray("error")[0].toString() == "The access token provided is invalid") {
                //myPreferences.setLogin(null)
                finishAffinity()
                openActivity(SplashActivity::class.java, null, true)
            } else {
                showToastLong(jsonObject.optJSONArray("error")[0].toString())
            }
        } catch (ignored: Exception) {

        }
    }

    abstract fun getLayout(): Int

    abstract fun init(savedInstanceState: Bundle?)

    open fun printHashKey() {
        try {
            val info: PackageInfo =
                packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val hashKey: String = String(Base64.encode(md.digest(), 0))
                Log.i("BAKAR_TAG", "printHashKey() Hash Key: $hashKey")
            }
        } catch (e: NoSuchAlgorithmException) {
            Log.e("BAKAR_TAG", "printHashKey()", e)
        } catch (e: java.lang.Exception) {
            Log.e("BAKAR_TAG", "printHashKey()", e)
        }
    }

}