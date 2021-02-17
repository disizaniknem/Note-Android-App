package com.disizaniknem.ktornoteapp.ui.addeditnote

import android.util.EventLog
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.disizaniknem.ktornoteapp.data.local.entities.Note
import com.disizaniknem.ktornoteapp.other.Event
import com.disizaniknem.ktornoteapp.other.Resource
import com.disizaniknem.ktornoteapp.repositories.NoteRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddEditNoteViewModel @ViewModelInject constructor(
    private val repository: NoteRepository
): ViewModel() {

    private val _note = MutableLiveData<Event<Resource<Note>>>()
    val note: LiveData<Event<Resource<Note>>> = _note

    fun insertNote(note: Note) = GlobalScope.launch {
        repository.insertNote(note)
    }

    fun getNoteById(noteId: String) = viewModelScope.launch {
        _note.postValue(Event(Resource.loading(null)))
        val note = repository.getNoteById(noteId)
        note?.let {
            _note.postValue(Event(Resource.success(it)))
        } ?: _note.postValue(Event(Resource.error("Note not found", null)))
    }
}