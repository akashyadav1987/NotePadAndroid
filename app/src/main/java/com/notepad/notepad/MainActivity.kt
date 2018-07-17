package com.notepad.notepad

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.notepad.notepad.fragments.createnote.CreateNoteFragment
import com.notepad.notepad.fragments.notelist.NoteListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        OpenNoteListFragment()
        fab.setOnClickListener { view ->
            OpenCreateNoteFragment()

        }
    }

    fun getFloatingActionButton(): FloatingActionButton {
        return fab
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun OpenCreateNoteFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.content_main,CreateNoteFragment(),CreateNoteFragment::javaClass.toString()).addToBackStack(CreateNoteFragment::javaClass.toString()).commit()
    }

    private fun OpenNoteListFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.content_main,NoteListFragment(),NoteListFragment::javaClass.toString()).addToBackStack(NoteListFragment::javaClass.toString()).commit()
    }
}
