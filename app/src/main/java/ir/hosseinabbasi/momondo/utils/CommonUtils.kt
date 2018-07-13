package ir.hosseinabbasi.momondo.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.format.DateFormat
import ir.hosseinabbasi.momondo.R
import java.util.*

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class CommonUtils {
    companion object {
        fun showLoadingDialog(context : Context) : ProgressDialog {
            val progressDialog = ProgressDialog(context)
            progressDialog.show()
            if (progressDialog.window != null) {
                progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            //TODO Use Company's logo for Loading
            progressDialog.setContentView(R.layout.progress_dialog)
            progressDialog.isIndeterminate = true
            progressDialog.setCancelable(true)
            progressDialog.setCanceledOnTouchOutside(false)
            return progressDialog
        }

        @JvmStatic
        fun timestampToDate(time: Long): String {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            cal.timeInMillis = time
            return DateFormat.format("HH:mm", cal).toString()
        }

        @JvmStatic
        fun minutesToHoursMinutes(time: Int): String {
            val hours = time / 60
            val minutes = time % 60
            return hours.toString() + ":" + minutes
        }
    }
}