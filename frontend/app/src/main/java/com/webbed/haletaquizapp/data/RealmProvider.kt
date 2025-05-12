package com.webbed.haletaquizapp.data

import com.webbed.haletaquizapp.models.Admin
import com.webbed.haletaquizapp.models.Topic
import com.webbed.haletaquizapp.models.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object RealmProvider {
    val realm: Realm by lazy {
        val config = RealmConfiguration.Builder(
            schema = setOf(User::class, Admin::class, Topic::class)
        )
            .name("haletaquizapp.realm")
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.open(config)
    }
}