package com.disizaniknem.ktornoteapp.ui.notedetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.disizaniknem.ktornoteapp.repositories.NoteRepository

class NoteDetailViewModel @ViewModelInject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    fun observeNoteById(noteId: String) = repository.observeNoteById(noteId)
}