package pslibrary.customview

import android.content.Context

interface DialogProvider {

    fun showSuccessDialog(context: Context,
                          msg: String,
                          confirmButtonAction: () -> Unit = {},
                          dismissAction: () -> Unit = {})

    fun showErrorDialog(context: Context,
                        msg: String,
                        confirmButtonAction: () -> Unit = {},
                        dismissAction: () -> Unit = {})

    fun dismissDialog()
}