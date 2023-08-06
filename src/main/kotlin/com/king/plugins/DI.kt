package com.king.plugins

import com.king.service.FixtureFinder
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureDI() {
    install(Koin) {
        modules(appModule)
    }
}

val appModule = module {
    single { FixtureFinder() }
}