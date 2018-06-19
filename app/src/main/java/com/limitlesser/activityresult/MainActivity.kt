package com.limitlesser.activityresult

import android.app.Activity
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK)
            Toast.makeText(this, "收到结果:${data?.getStringExtra("data")}", Toast.LENGTH_SHORT)
                    .show()
    }
}
