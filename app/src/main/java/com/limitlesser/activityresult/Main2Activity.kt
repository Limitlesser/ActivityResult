package com.limitlesser.activityresult

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.limitlesser.activityresult.app.R

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data", "hello world")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
