package com.example.practicumguide2

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.btnShowAll).setOnClickListener {
            val list = MainActivity.packingList
            val msg = list.joinToString("\n") { "${it.name} (x${it.quantity})" }
            Toast.makeText(this, msg.ifEmpty { "List is empty" }, Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.btnShowFiltered).setOnClickListener {
            val filtered = MainActivity.packingList.filter { it.quantity >= 2 }
            val msg = filtered.joinToString("\n") { "${it.name} (x${it.quantity})" }
            Toast.makeText(this, msg.ifEmpty { "No items with quantity ≥ 2" }, Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.btnReturn).setOnClickListener {
            finish()
        }
    }
}