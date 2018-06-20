package com.limitlesser.activityresult

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.limitlesser.activityresult.app.R

class MainActivity : ResultActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val button3 = findViewById<Button>(R.id.button3)
        button.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivityForResult(intent)
                    .subscribe {
                        if (it.isOk)
                            Toast.makeText(this, "收到结果:${it.data?.getStringExtra("data")}", Toast.LENGTH_SHORT)
                                    .show()
                    }
        }
        button3.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivityForResult(intent, 1)
            waitingActivityResult(1)
                    .subscribe {
                        if (it.isOk)
                            Toast.makeText(this, "收到结果:${it.data?.getStringExtra("data")}", Toast.LENGTH_SHORT)
                                    .show()
                    }
        }

    }

}
