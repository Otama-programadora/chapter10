package com.example.chapter10

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class BloodPressure : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var dateTime: Date = Date()
    var max:Long = 0
    var min: Long = 0
    var pulse: Long = 0
}