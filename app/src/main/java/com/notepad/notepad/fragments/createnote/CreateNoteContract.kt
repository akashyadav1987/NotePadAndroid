package com.notepad.notepad.fragments.createnote

/**
 * Created by akashyadav on 7/18/18.
 */
class CreateNoteContract {

    interface CreateNoteView {
        fun initializeView()
        fun listenToUserAction()
    }

    interface CreateNotePresenter{
        fun startPresenter()
    }
}