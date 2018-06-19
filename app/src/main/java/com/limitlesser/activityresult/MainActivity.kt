package com.limitlesser.activityresult

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.limitlesser.activityresult.app.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivityForResult(intent)
                    .subscribe {
                        if (it.isOk)
                            Toast.makeText(this, "收到结果:${it.data?.getStringExtra("data")}", Toast.LENGTH_SHORT)
                                    .show()
                    }
        }
    }

}
