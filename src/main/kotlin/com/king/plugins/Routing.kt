package com.king.plugins

import com.king.service.FixtureFinder
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.html.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    routing {
        val fixtureFinder: FixtureFinder by inject()
        get("/") {
            val session = call.sessions.get<UserSession>()
            if (session == null) {
                call.respondRedirect("/login")
            } else {
                // The user is authenticated.
                val fixtures = fixtureFinder.grabFixtures()
                call.respondHtml(HttpStatusCode.OK) {
                    head {
                        title {
                            "Football Tipsters"
                        }
                    }
                    body {
                        h1 {
                            +"Welcome, ${session.name}. Please predict the following fixtures:"
                        }
                        div {
                            fixtures.map {
                                span {
                                    +"${it.commenceTime } ${it.homeTeam} vs ${it.awayTeam}"
                                }
                                br
                            }
                        }
                    }
                }
            }
        }
    }
}
