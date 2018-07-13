package ir.hosseinabbasi.momondo.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class NetworkUtils {

    companion object {
        fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }
    }
}