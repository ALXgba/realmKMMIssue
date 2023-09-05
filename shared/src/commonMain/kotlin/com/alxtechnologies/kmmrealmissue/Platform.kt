package com.realmtests.kmmrealmissue

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform