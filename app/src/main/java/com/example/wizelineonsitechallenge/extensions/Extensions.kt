@file:JvmName("ExtensionsUtils")

package com.example.wizelineonsitechallenge.extensions

import android.content.res.Resources

fun dp2px(dp: Int): Float = dp * Resources.getSystem().displayMetrics.density