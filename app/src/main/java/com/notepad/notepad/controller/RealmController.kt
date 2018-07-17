package com.notepad.notepad.controller

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.notepad.notepad.model.Note
import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by akashyadav on 7/17/18.
 */
class RealmController() {
    val realm: Realm
    internal var index = 0

    //find all objects in the Book.class
    val allNotes: RealmResults<Note>
        get() = realm.where(Note::class.java).findAll()

    /**This method is used for editing notes**/
    fun editNote(note: Note): Note? {
        try {
            val noteFromDB = realm.where(Note::class.java).equalTo("time", note.time).findFirst()
            realm.beginTransaction()
            noteFromDB.actual_note= note.actual_note
            realm.commitTransaction()
            return note
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    init {
        realm = Realm.getDefaultInstance()
    }

    /**This method is responsible for adding notes**/
    fun addNote(note: Note) {
       try {
            realm.executeTransaction { realm -> realm.copyToRealmOrUpdate(note) }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //clear all objects from Book.class
    fun clearAll() {
        realm.beginTransaction()
        //realm..clear(FavoriteMural.class);
        realm.commitTransaction()
    }

    companion object {
        var instance: RealmController? = null
            private set

        fun with(fragment: Fragment): RealmController {

            if (instance == null) {
                instance = RealmController()
            }
            return instance as RealmController
        }

        fun with(): RealmController {

            if (instance == null) {
                instance = RealmController()
            }
            return instance as RealmController
        }

        fun with(activity: Activity): RealmController {

            if (instance == null) {
                instance = RealmController()
            }
            return instance as RealmController
        }

        fun with(application: Application): RealmController {

            if (instance == null) {
                instance = RealmController()
            }
            return instance as RealmController
        }
    }
}
