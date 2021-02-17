package com.disizaniknem.ktornoteapp.ui.notes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.disizaniknem.ktornoteapp.data.local.entities.Note
import com.disizaniknem.ktornoteapp.other.Event
import com.disizaniknem.ktornoteapp.other.Resource
import com.disizaniknem.ktornoteapp.repositories.NoteRepository

class NotesViewModel @ViewModelInject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    private val _forceUpdate = MutableLiveData<Boolean>(false)

    private val _allNotes = _forceUpdate.switchMap {
        repository.getAllNotes().asLiveData(viewModelScope.coroutineContext)
    }.switchMap {
        MutableLiveData(Event(it))
    }

    val allNotes: LiveData<Event<Resource<List<Note>>>> = _allNotes

    fun syncAllNotes() = _forceUpdate.postValue(true)

}