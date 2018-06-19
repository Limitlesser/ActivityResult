package com.limitlesser.activityresult

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity


open class ResultActivity : AppCompatActivity(), ResultHandler {

    override val activity: Activity
        get() = this
    override val dispatcher: ResultDispatcher = ResultDispatcher()

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        dispatcher.onActivityResult(requestCode, resultCode, data)
    }
}

