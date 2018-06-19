package com.limitlesser.activityresult

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : ResultActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivityForResult(intent)
                    .subscribe {
                        Toast.makeText(this, "收到结果:${it.data?.getStringExtra("data")}", Toast.LENGTH_SHORT)
                                .show()
                    }
        }

    }
}
