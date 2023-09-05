package com.realmtests.kmmrealmissue.shared.realmleaker

//import com.kmmrealmissue.shared.schema.TestClass
import com.realmtests.kmmrealmissue.shared.schema.TestClass
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class RealmLeaker {
    fun leak() {
        val config = RealmConfiguration.Builder(setOf(TestClass::class))
            .build()

        // This should simply open, then close the realm. Note that if you comment everything below this, there is no leak.
        val realm: Realm = Realm.open(config)
        realm.close()
    }
}