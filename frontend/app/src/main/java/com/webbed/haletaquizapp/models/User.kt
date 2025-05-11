package com.webbed.haletaquizapp.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.UUID

class User : RealmObject {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var username: String = ""
    var password: String = ""
    var resetA1: String = ""
    var resetA2: String = ""
}
