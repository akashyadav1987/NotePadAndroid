package com.notepad.notepad.fragments.notelist

import com.notepad.notepad.controller.RealmController

/**
 * Created by akashyadav on 7/18/18.
 */
class NoteListPresenter(var view:NoteListContract.NoteListBaseView) :NoteListContract.NoteListPresenter {

    /***This method will initialize view */
    override fun startPresenter() {
        view.initializeView()
    }

    /**This method will be responsible for fetching all the notes which is saved on user database */
    override fun fetchAllCreatedNotes() {
     view.onAllNotesFetched(RealmController.with().allNotes)
    }

}