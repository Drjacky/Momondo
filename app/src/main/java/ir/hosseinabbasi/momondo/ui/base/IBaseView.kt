package ir.hosseinabbasi.momondo.ui.base

import android.support.annotation.StringRes

/**
 * Created by Dr.jacky on 2018/06/29.
 */
interface IBaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(@StringRes resId: Int)
    fun onError(message: String?)
    fun isNetworkConnected(): Boolean
}