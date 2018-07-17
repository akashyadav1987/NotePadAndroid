package com.notepad.notepad.fragments.createnote

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.AppCompatEditText
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.notepad.notepad.MainActivity
import com.notepad.notepad.R
import com.notepad.notepad.base.BaseFragment
import com.notepad.notepad.controller.RealmController
import com.notepad.notepad.model.Note
import kotlinx.android.synthetic.main.create_note_fragment.*

/**
 * Created by akashyadav on 7/18/18.
 */
class CreateNoteFragment :BaseFragment(),CreateNoteContract.CreateNoteView{

    private lateinit var presenter:CreateNoteContract.CreateNotePresenter
    private var note:Note?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CreateNotePresenter(this)
        presenter.startPresenter()
        val floatingActionButton = (activity as MainActivity).getFloatingActionButton()
        if(floatingActionButton!=null){
            floatingActionButton.hide()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.create_note_fragment,null)
    }

    /**initializing view **/
    override fun initializeView() {
        note = Note()
    }

    override fun listenToUserAction() {
        save_note.setOnClickListener{
            if(!note_content.text.trim().isEmpty()){
                showTitleDialogue()
            }else{
                Toast.makeText(activity,"Please input some character to save your note",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showTitleDialogue(){
        val alertDialogue = activity?.let {
            AlertDialog.Builder(it)
        }

        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_dialog, null)
        alertDialogue?.setView(dialogView)

        val inputBoxTitle = dialogView.findViewById<View>(R.id.note_title) as AppCompatEditText

        alertDialogue?.setMessage("Please input the title")
        alertDialogue?.let {
            it.setCancelable(false)
            it.setNegativeButton("Cancel", { dialog, _ ->
                //pass
                dialog.dismiss()

            })

            it.setPositiveButton("Save", { dialog, _ ->
                //do something with edt.getText().toString();

                dialog.dismiss()

                if(!inputBoxTitle.text.trim().isEmpty()){
                    note?.title = inputBoxTitle.text.trim().toString()
                    note?.actual_note= note_content.text.trim().toString()
                    note?.time = System.currentTimeMillis()

                    /***saving record to db after validations**/

                    activity?.let { it1 -> note?.let { it2 -> RealmController.with(it1).addNote(it2) } }

                    activity?.supportFragmentManager?.popBackStackImmediate()
                }else
                {
                    Toast.makeText(activity,"Title can't be empty",Toast.LENGTH_SHORT).show()
                }

            })
            val dialogue= it.create()
            dialogue.show()
        }
    }
}