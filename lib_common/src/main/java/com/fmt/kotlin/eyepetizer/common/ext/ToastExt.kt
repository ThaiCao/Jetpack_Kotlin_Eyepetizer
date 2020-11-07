package com.fmt.kotlin.eyepetizer.common.ext

import com.fmt.kotlin.eyepetizer.common.util.AppGlobal
import com.sdsmdg.tastytoast.TastyToast

fun errorToast(message: String) {
    AppGlobal.get()
        ?.let { TastyToast.makeText(it, message, TastyToast.LENGTH_LONG, TastyToast.ERROR) }
}