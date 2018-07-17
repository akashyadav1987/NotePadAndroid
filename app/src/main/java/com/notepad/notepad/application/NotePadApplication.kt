package com.notepad.notepad.application

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by akashyadav on 7/18/18.
 */
class NotePadApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }
}