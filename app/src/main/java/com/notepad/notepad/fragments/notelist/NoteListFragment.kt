package com.notepad.notepad.fragments.notelist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.notepad.notepad.MainActivity
import com.notepad.notepad.R
import com.notepad.notepad.adapter.NoteListAdapter
import com.notepad.notepad.base.BaseFragment
import com.notepad.notepad.model.Note
import kotlinx.android.synthetic.main.notelist_fragment.*



/**
 * Created by akashyadav on 7/18/18.
 * Fragment will contain all the note list which is created by user
 */
class NoteListFragment : BaseFragment() ,NoteListContract.NoteListBaseView{

    private lateinit var noteListPresenter :NoteListContract.NoteListPresenter
    private var noteListAdapter:NoteListAdapter?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.notelist_fragment,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteListPresenter  = NoteListPresenter(this)
        noteListPresenter.startPresenter()
        val floatingActionButton = (activity as MainActivity).getFloatingActionButton()
        if(floatingActionButton!=null){
            floatingActionButton.show()
        }

    }

    override fun initializeView() {
        val linearlayoutMgr = LinearLayoutManager(activity)
        note_list.layoutManager = linearlayoutMgr
        noteListAdapter = activity?.let {
            NoteListAdapter(it, mutableListOf())
        }
        note_list.adapter = noteListAdapter
        noteListPresenter.fetchAllCreatedNotes()
    }

    override fun onAllNotesFetched(noteList: MutableList<Note>) {
        if(noteList.size==0){
            no_items.visibility = View.VISIBLE
            note_list.visibility = View.GONE
        }else{
            no_items.visibility = View.GONE
            note_list.visibility = View.VISIBLE
        }
        noteListAdapter?.let {
            it.notify(noteList)
        }
    }
}