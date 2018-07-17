package com.notepad.notepad.model

import android.annotation.SuppressLint
import android.os.Parcelable
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by akashyadav on 7/17/18.
 */
@SuppressLint("ParcelCreator")
@Parcelize
open class Note(var title:String?=null, @PrimaryKey public var time:Long?=null, var actual_note:String?=null) : RealmObject(), RealmModel, Parcelable