package com.example.vehiclenote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vehiclenote.databinding.ActivityUpdateNoteBinding


class UpdateNoteActivity : AppCompatActivity() {



    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db: NotesDatabaseHelper
    private  var noteId: Int= -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id", -1)
        if (noteId==-1){
            finish()
            return
        }

        val note = db.getNoteByID(noteId)
        binding.updatetitleedittext.setText(note.title)

        binding.updateedittext.setText(note.content)

        binding.updatesavebutton.setOnClickListener{
            val newTitle = binding.updatetitleedittext.text.toString()
            val newContent = binding.updateedittext.text.toString()
            val updatedNote = Note(noteId, newTitle, newContent)
            db.updateNote(updatedNote)
            finish()
            Toast.makeText(this, "Changes saved", Toast.LENGTH_SHORT).show()
        }
    }
}