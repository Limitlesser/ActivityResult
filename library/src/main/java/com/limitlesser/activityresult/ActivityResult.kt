package com.limitlesser.activityresult

import android.app.Activity
import android.content.Intent


data class ActivityResult(val requestCode: Int, val resultCode: Int, val data: Intent?) {
    val isOk = resultCode == Activity.RESULT_OK
}