package com.webbed.haletaquizapp

import android.app.Application
import com.webbed.haletaquizapp.models.Admin
import com.webbed.haletaquizapp.models.Topic
import com.webbed.haletaquizapp.models.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class HaletaQuizApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Create a Realm configuration
        val config = RealmConfiguration.Builder(
            schema = setOf(
                User::class,
                Topic::class,
                Admin::class
                )
        )
            .name("haletaquizapp.realm")
            .schemaVersion(1)
            .build()

        Realm.open(config)
    }
}
