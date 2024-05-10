package com.example.vehiclenote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vehiclenote.databinding.ActivityMainBinding

class addnotes : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnotes)
    }
}