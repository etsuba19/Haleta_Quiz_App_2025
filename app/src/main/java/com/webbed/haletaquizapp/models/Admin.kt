package com.webbed.haletaquizapp.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Admin : RealmObject {
    @PrimaryKey
    var username: String = ""
    var password: String = ""
    var canManageUsers: Boolean = true
    var canManageQuizzes: Boolean = true
    var canManageResources: Boolean = true
}
