package ir.hosseinabbasi.momondo.ui.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import butterknife.Unbinder
import ir.hosseinabbasi.momondo.di.component.ActivityComponent

/**
 * Created by Dr.jacky on 2018/06/29.
 */
open class BaseFragment : Fragment(), IBaseView {
    private var mActivity: BaseActivity? = null
    private var mUnBinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.mActivity = activity
            activity!!.onFragmentAttached()
        }
    }

    override fun showLoading() {
        mActivity?.showLoading()
    }

    override fun hideLoading() {
        mActivity?.hideLoading()
    }

    override fun onError(message: String?) {
        mActivity?.onError(message)
    }

    override fun onError(@StringRes resId: Int) {
        mActivity?.onError(resId)
    }

    override fun isNetworkConnected(): Boolean {
        return mActivity?.isNetworkConnected() ?: false
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    fun getActivityComponent(): ActivityComponent? {
        return mActivity?.activityComponent
    }

    fun getBaseActivity(): BaseActivity? {
        return mActivity
    }

    fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    override fun onDestroy() {
        mUnBinder?.unbind()
        super.onDestroy()
    }

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }
}