package com.limitlesser.activityresult

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


interface ResultHandler {

    val activity: Activity

    val dispatcher: ResultDispatcher

    fun startActivityForResult(intent: Intent, options: Bundle? = null): Observable<ActivityResult> {
        val requestCode = dispatcher.nextRequestCode()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            activity.startActivityForResult(intent, requestCode, options)
        else activity.startActivityForResult(intent, requestCode)
        return dispatcher.addSubject(requestCode)
    }
}

class ResultDispatcher {

    val subjects = mutableMapOf<Int, PublishSubject<ActivityResult>>()

    private var code = 0

    fun nextRequestCode(): Int {
        return REQUEST_CODE + code++
    }

    fun addSubject(requestCode: Int): Observable<ActivityResult> {
        val subject = PublishSubject.create<ActivityResult>()
        subjects[requestCode] = subject
        return subject
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val subject = subjects.remove(requestCode)
        subject?.onNext(ActivityResult(requestCode, resultCode, data))
    }

    companion object {
        const val REQUEST_CODE = 300
    }

}