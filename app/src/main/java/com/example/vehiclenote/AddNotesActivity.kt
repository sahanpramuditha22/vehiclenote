package com.example.vehiclenote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vehiclenote.databinding.ActivityAddnotesBinding

class AddNotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddnotesBinding
    private lateinit var db: NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddnotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)
        binding.savebutton.setOnClickListener{
            val title = binding.titleedittext.text.toString()
            val content = binding.edittext.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
        }
    }
}
