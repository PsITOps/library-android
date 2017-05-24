package pslibrary.customview

import android.content.Context
import android.graphics.Color
import cn.pedant.SweetAlert.SweetAlertDialog


class SweetDialogProvider : DialogProvider {

    private var pDialog: SweetAlertDialog? = null

    override fun dismissDialog() {
        if (pDialog != null && pDialog!!.isShowing) {
            pDialog!!.dismiss()
        }
    }

    override fun showSuccessDialog(context: Context, msg: String, confirmButtonAction: () -> Unit, dismissAction: () -> Unit) {
        dismissDialog()

        pDialog = SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE).apply {
            progressHelper.barColor = Color.parseColor("#5ce80d")
            titleText = "Sukces"
            contentText = msg
            confirmText = "OK"
            setConfirmClickListener { confirmButtonAction.invoke() }
            setOnDismissListener { dismissAction.invoke() }
        }
        pDialog!!.show()
    }

    override fun showErrorDialog(context: Context, msg: String, confirmButtonAction: () -> Unit, dismissAction: () -> Unit) {
        dismissDialog()

        pDialog = SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE).apply {
            progressHelper.barColor = Color.parseColor("#e80c17")
            titleText = "Error"
            contentText = msg
            confirmText = "Spróbuj ponownie"
            setConfirmClickListener { confirmButtonAction.invoke() }
            setOnDismissListener { dismissAction.invoke() }
        }
        pDialog!!.show()
    }
}