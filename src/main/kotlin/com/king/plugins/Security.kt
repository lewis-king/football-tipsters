package com.king.plugins

import com.auth0.jwt.JWT
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.*

fun Application.configureSecurity() {
    authentication {
        oauth("keycloakOAuth") {
            urlProvider = { "http://localhost:8080/login" }
            providerLookup = {
                OAuthServerSettings.OAuth2ServerSettings(
                    name = "keycloak",
                    authorizeUrl = "http://localhost:9000/auth/realms/tipsters/protocol/openid-connect/auth",
                    accessTokenUrl = "http://localhost:9000/auth/realms/tipsters/protocol/openid-connect/token",
                    clientId = "football-tipsters-api",
                    clientSecret = System.getenv("CLIENT_AUTH_SECRET"),
                    defaultScopes = listOf("openid"),
                    accessTokenRequiresBasicAuth = false,
                    requestMethod = HttpMethod.Post
                )
            }
            client = HttpClient(Apache)
        }
    }
    routing {
        authenticate("keycloakOAuth") {
            get("/login") {
                val principal = call.authentication.principal<OAuthAccessTokenResponse.OAuth2>()
                if (principal != null) {
                    // Decode the access token (which is a JWT) without verifying it.
                    val decodedJWT = JWT.decode(principal.accessToken)

                    // Get the user's name from the JWT claims.
                    val name = decodedJWT.getClaim("name")?.asString() ?: "unknown user"
                    val id = decodedJWT.getClaim("sid")?.asString() ?: ""
                    val username = decodedJWT.getClaim("preferred_username")?.asString() ?: ""
                    call.sessions.set(UserSession(id, username, name))

                    call.respondRedirect("/")
                } else {
                    call.respondText("Authentication failed.", status = HttpStatusCode.Unauthorized)
                }
            }
        }
    }
}

fun Application.configureSession() {
    install(Sessions) {
        cookie<UserSession>("USER_SESSION") {
            cookie.extensions["SameSite"] = "lax"
            transform(SessionTransportTransformerMessageAuthentication(hashKey))
        }
    }
}

val hashKey = hex("00112233445566778899aabbccddeeff") // secret hash for signing the session cookie. Just hardcoded for demo purposes

data class UserSession(val userId: String, val username: String, val name: String)
