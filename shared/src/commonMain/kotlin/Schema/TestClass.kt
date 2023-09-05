package com.realmtests.kmmrealmissue.shared.schema

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

// This class isn't really useful. Only there to showcase the leak, its properties are outside the scope of the problem.
class TestClass : RealmObject{
    @PrimaryKey
    var _id : String = "0"

    var value : Boolean = false
    var key : String = "test"
}