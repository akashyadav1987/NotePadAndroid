package com.notepad.notepad.adapter

import android.app.Activity
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.notepad.notepad.R
import com.notepad.notepad.model.Note
import java.text.SimpleDateFormat


/**
 * Created by akashyadav on 7/18/18.
 */
class NoteListAdapter(var context:Activity,var noteList:MutableList<Note>) : RecyclerView.Adapter<NoteListAdapter.NoteListViewHolder>() {


    override fun onBindViewHolder(holder: NoteListViewHolder, position: Int) {

        try{
            val note = noteList.get(position)
            note.let {
                holder.note_content_main.text =note.actual_note
                holder.note_title.text = note.title
                val simpleDateFormatter = SimpleDateFormat("EEE, DD/mm/yyyy HH:mm")
                holder.note_time.text = simpleDateFormatter.format(note.time)

            }
        }catch (e:Exception){

        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListViewHolder {
        return NoteListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note_list,parent,false))
    }

     class  NoteListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val note_content_main = itemView.findViewById<AppCompatTextView>(R.id.note_content_text)
         val note_time = itemView.findViewById<AppCompatTextView>(R.id.note_created_time_content)
         val note_title = itemView.findViewById<AppCompatTextView>(R.id.note_title)
    }

     /**method to notify adapter*/
     fun notify(noteList:MutableList<Note>){
        this.noteList = noteList
        notifyDataSetChanged()
    }
}



