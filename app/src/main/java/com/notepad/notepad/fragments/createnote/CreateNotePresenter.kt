package com.notepad.notepad.fragments.createnote

/**
 * Created by akashyadav on 7/18/18.
 */
class CreateNotePresenter(var view:CreateNoteContract.CreateNoteView):CreateNoteContract.CreateNotePresenter {

    /**This method is responsible for starting presenter*/
    override fun startPresenter() {
        view.initializeView()
        view.listenToUserAction()
    }
}