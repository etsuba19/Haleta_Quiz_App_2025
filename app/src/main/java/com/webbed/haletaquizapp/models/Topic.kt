package com.webbed.haletaquizapp.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Topic : RealmObject {
    @PrimaryKey
    var id: String = ""
    var label: String = ""
    var topicKey: String = ""
}
