package pslibrary.customview

import android.content.Context
import android.graphics.Color
import cn.pedant.SweetAlert.SweetAlertDialog


class SweetDialogProvider : DialogProvider {

    override fun showSuccessDialog(context: Context, msg: String, confirmButtonAction: () -> Unit, dismissAction: () -> Unit) {
        val pDialog = SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE).apply {
            progressHelper.barColor = Color.parseColor("#A5DC86")
            titleText = "Success"
            contentText = msg
            confirmText = "Sweet!"
            setConfirmClickListener { confirmButtonAction.invoke() }
            setOnDismissListener { dismissAction.invoke() }
        }
        pDialog.show()
    }

    override fun showErrorDialog(context: Context, msg: String, confirmButtonAction: () -> Unit, dismissAction: () -> Unit) {

    }
}