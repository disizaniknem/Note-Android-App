package com.disizaniknem.ktornoteapp.ui.notedetail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.disizaniknem.ktornoteapp.R
import com.disizaniknem.ktornoteapp.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_note_detail.*

class NoteDetailFragment : BaseFragment(R.layout.fragment_note_detail) {

    private val args: NoteDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabEditNote.setOnClickListener {
            findNavController().navigate(
                NoteDetailFragmentDirections.actionNoteDetailFragmentToAddEditNoteFragment(args.id)
            )
        }
    }

}