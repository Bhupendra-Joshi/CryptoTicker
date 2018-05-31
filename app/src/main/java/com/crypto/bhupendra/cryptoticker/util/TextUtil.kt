package com.crypto.bhupendra.cryptoticker.util

import android.support.annotation.IntegerRes
import java.text.DecimalFormat

/**
 * Created by bhupendra on 16/12/17.
 */
class TextUtil {

    companion object {
        @JvmStatic
        fun formatNumberString(numberString: String?): String {
            if (numberString == null) {
                return ""
            }
            var newString: String = DecimalFormat("##,##,##,###.00").format(numberString.toFloat())
            return newString
        }
    }
}