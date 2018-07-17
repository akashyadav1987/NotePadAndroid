package com.notepad.notepad.fragments.notelist

import com.notepad.notepad.model.Note

/**
 * Created by akashyadav on 7/18/18.
 */
class NoteListContract {

    interface NoteListBaseView {
        fun initializeView()
        fun onAllNotesFetched(noteList:MutableList<Note>)
    }

    interface NoteListPresenter{
        fun startPresenter()
        fun fetchAllCreatedNotes()
    }
}