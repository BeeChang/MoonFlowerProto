package com.example.moonflowerproto

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform