package com.example.practicumguide2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AlertDialog.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        val packingList = mutableListOf<PackingItem>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameInput = findViewById<EditText>(R.id.editName)
        val quantityInput = findViewById<EditText>(R.id.editQuantity)
        val addButton = findViewById<Button>(R.id.btnAdd)
        val nextScreenButton = findViewById<Button>(R.id.btnNext)
        val exitButton = findViewById<Button>(R.id.btnExit)

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val quantity = quantityInput.text.toString().toIntOrNull() ?: 0

            if (name.isNotBlank() && quantity > 0) {
                packingList.add(PackingItem(name, quantity))
                Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()
                nameInput.text.clear()
                quantityInput.text.clear()
            } else {
                Toast.makeText(this, "Please enter a valid name and quantity", Toast.LENGTH_SHORT).show()
            }
        }

        nextScreenButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}