package com.king.service

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.time.Instant

const val endpoint =  "https://api.the-odds-api.com/v4/sports/soccer_epl/odds/?apiKey=76bef19bae189a71c19de0cb13b7bd95&regions=uk"
class FixtureFinder {
    private val client = HttpClient(CIO) {
        install(Logging) {
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            Json {
                ignoreUnknownKeys = true
            }
        }
    }
    suspend fun grabFixtures(): List<Fixture> {
        val response = Json{ignoreUnknownKeys = true}.decodeFromString<List<Fixture>>(payload)
        return response

        //val response: HttpResponse = client.get(endpoint)
        //return response.body<Fixtures>()
    }

}

/*
        "id": "8f77bda60a2e394a76b139a8e0efb986",
        "sport_key": "soccer_epl",
        "sport_title": "EPL",
        "commence_time": "2023-08-11T19:00:00Z",
        "home_team": "Burnley",
        "away_team": "Manchester City",
 */
@Serializable
data class Fixture(
    val id: String,
    @SerialName("sport_key")
    val sportKey: String,
    @SerialName("sport_title")
    val sportTitle: String,
    @SerialName("commence_time")
    val commenceTime: String,
    @SerialName("home_team")
    val homeTeam: String,
    @SerialName("away_team")
    val awayTeam: String,
)

@Serializable
data class Fixtures(
    val fixtures: List<Fixture>
)

val payload = """
    [
        {
            "id": "8f77bda60a2e394a76b139a8e0efb986",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-11T19:00:00Z",
            "home_team": "Burnley",
            "away_team": "Manchester City",
            "bookmakers": [
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 10.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.25
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 8.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 11.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.31
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.2
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 12.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.32
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 11.0
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 9.0
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.29
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 9.0
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.29
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 11.0
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 9.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.25
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 9.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.27
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 10.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.29
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 9.0
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.29
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "boylesports",
                    "title": "BoyleSports",
                    "last_update": "2023-08-06T08:54:49Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:49Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 10.0
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.29
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "leovegas",
                    "title": "LeoVegas",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 9.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.28
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "casumo",
                    "title": "Casumo",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 9.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "mrgreen",
                    "title": "Mr Green",
                    "last_update": "2023-08-06T08:55:07Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:07Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 9.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.29
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "unibet_uk",
                    "title": "Unibet",
                    "last_update": "2023-08-06T08:53:55Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:55Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 9.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "matchbook",
                    "title": "Matchbook",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 11.5
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.31
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.2
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Burnley",
                                    "price": 12.0
                                },
                                {
                                    "name": "Manchester City",
                                    "price": 1.32
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.4
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "108e8f161fea0bb6887202c5972f2579",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-12T11:30:00Z",
            "home_team": "Arsenal",
            "away_team": "Nottingham Forest",
            "bookmakers": [
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.25
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 10.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.22
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 12.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.27
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 12.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 7.0
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.28
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 13.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 7.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.25
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 12.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.22
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 10.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.22
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 10.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.25
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 12.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.22
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 11.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.22
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 10.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.25
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 9.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "boylesports",
                    "title": "BoyleSports",
                    "last_update": "2023-08-06T08:54:49Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:49Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.2
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 12.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "leovegas",
                    "title": "LeoVegas",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.22
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 11.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "casumo",
                    "title": "Casumo",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.24
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 11.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "mrgreen",
                    "title": "Mr Green",
                    "last_update": "2023-08-06T08:55:07Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:07Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.23
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 11.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "unibet_uk",
                    "title": "Unibet",
                    "last_update": "2023-08-06T08:53:55Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:55Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.24
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 11.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.22
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 12.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "matchbook",
                    "title": "Matchbook",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.26
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 13.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.6
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.29
                                },
                                {
                                    "name": "Nottingham Forest",
                                    "price": 14.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 7.4
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "ea006c3beecf16853eb5fde5447d77bb",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-12T14:00:00Z",
            "home_team": "Bournemouth",
            "away_team": "West Ham United",
            "bookmakers": [
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.75
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.76
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.74
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.55
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.82
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.55
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.45
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.45
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.35
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.55
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "boylesports",
                    "title": "BoyleSports",
                    "last_update": "2023-08-06T08:54:49Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:49Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "leovegas",
                    "title": "LeoVegas",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.65
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "casumo",
                    "title": "Casumo",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.63
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.45
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "mrgreen",
                    "title": "Mr Green",
                    "last_update": "2023-08-06T08:55:07Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:07Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.65
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.63
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.45
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "unibet_uk",
                    "title": "Unibet",
                    "last_update": "2023-08-06T08:53:55Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:55Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.7
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.63
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.45
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "matchbook",
                    "title": "Matchbook",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 2.48
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 2.36
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.55
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 3.3
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.1
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.3
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "6696291a9110a5d0810c34eeaa244a41",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-12T14:00:00Z",
            "home_team": "Brighton and Hove Albion",
            "away_team": "Luton",
            "bookmakers": [
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.29
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.29
                                },
                                {
                                    "name": "Luton",
                                    "price": 8.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.29
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.33
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.33
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.34
                                },
                                {
                                    "name": "Luton",
                                    "price": 11.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.8
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.36
                                },
                                {
                                    "name": "Luton",
                                    "price": 12.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.29
                                },
                                {
                                    "name": "Luton",
                                    "price": 8.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "boylesports",
                    "title": "BoyleSports",
                    "last_update": "2023-08-06T08:54:49Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:49Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.29
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "leovegas",
                    "title": "LeoVegas",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.29
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "casumo",
                    "title": "Casumo",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.3
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.29
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.29
                                },
                                {
                                    "name": "Luton",
                                    "price": 9.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "mrgreen",
                    "title": "Mr Green",
                    "last_update": "2023-08-06T08:55:07Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:07Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.3
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "unibet_uk",
                    "title": "Unibet",
                    "last_update": "2023-08-06T08:53:55Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:55Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.3
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.3
                                },
                                {
                                    "name": "Luton",
                                    "price": 8.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.29
                                },
                                {
                                    "name": "Luton",
                                    "price": 10.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "matchbook",
                    "title": "Matchbook",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.27
                                },
                                {
                                    "name": "Luton",
                                    "price": 9.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.8
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.43
                                },
                                {
                                    "name": "Luton",
                                    "price": 13.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.4
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "4f07a4c7058a9db2f29864c8ad4344c0",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-12T14:00:00Z",
            "home_team": "Sheffield United",
            "away_team": "Crystal Palace",
            "bookmakers": [
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.45
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 2.9
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.4
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.54
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.6
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.25
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.35
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.5
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 2.87
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.1
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.38
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.1
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.38
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.1
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.55
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 2.87
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.45
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 2.88
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.45
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 2.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.15
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.45
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.12
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.38
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.1
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "boylesports",
                    "title": "BoyleSports",
                    "last_update": "2023-08-06T08:54:49Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:49Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.38
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.1
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "leovegas",
                    "title": "LeoVegas",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.5
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 2.9
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "casumo",
                    "title": "Casumo",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.55
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 2.95
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "mrgreen",
                    "title": "Mr Green",
                    "last_update": "2023-08-06T08:55:07Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:07Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.5
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 2.95
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "unibet_uk",
                    "title": "Unibet",
                    "last_update": "2023-08-06T08:53:55Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:55Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.55
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 2.95
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "matchbook",
                    "title": "Matchbook",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.48
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.1
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.15
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Crystal Palace",
                                    "price": 2.66
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.35
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.45
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "46e89fad13b8b860d46d06c456986f26",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-12T14:00:00Z",
            "home_team": "Everton",
            "away_team": "Fulham",
            "bookmakers": [
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.2
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.15
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.24
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.55
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.26
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.65
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.2
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.15
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.15
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.2
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.15
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.15
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.35
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.2
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.15
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "boylesports",
                    "title": "BoyleSports",
                    "last_update": "2023-08-06T08:54:49Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:49Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.1
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "leovegas",
                    "title": "LeoVegas",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.1
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.45
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "casumo",
                    "title": "Casumo",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.14
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.45
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.55
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "mrgreen",
                    "title": "Mr Green",
                    "last_update": "2023-08-06T08:55:07Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:07Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.12
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.45
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "unibet_uk",
                    "title": "Unibet",
                    "last_update": "2023-08-06T08:53:55Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:55Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.14
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.45
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.55
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "matchbook",
                    "title": "Matchbook",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.16
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.25
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Everton",
                                    "price": 2.44
                                },
                                {
                                    "name": "Fulham",
                                    "price": 3.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "6befc8591ae2fb5174af39dd64c17635",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-12T16:30:00Z",
            "home_team": "Newcastle United",
            "away_team": "Aston Villa",
            "bookmakers": [
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.6
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.73
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.6
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.9
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.8
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.81
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.1
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.9
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.83
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.8
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.33
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.33
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.8
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.75
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.4
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.71
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.7
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.75
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.33
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "boylesports",
                    "title": "BoyleSports",
                    "last_update": "2023-08-06T08:54:49Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:49Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.5
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.67
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "leovegas",
                    "title": "LeoVegas",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.7
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.68
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "casumo",
                    "title": "Casumo",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.75
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.71
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "mrgreen",
                    "title": "Mr Green",
                    "last_update": "2023-08-06T08:55:07Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:07Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.7
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.71
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "unibet_uk",
                    "title": "Unibet",
                    "last_update": "2023-08-06T08:53:55Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:55Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.75
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.71
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "matchbook",
                    "title": "Matchbook",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 4.3
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.69
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.65
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 5.6
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 1.94
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.2
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "d27e612363f30c10a919722cb0790880",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-13T13:00:00Z",
            "home_team": "Brentford",
            "away_team": "Tottenham Hotspur",
            "bookmakers": [
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.88
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.88
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 3.05
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.48
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.65
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 3.1
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.7
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.87
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.37
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.75
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.75
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.87
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.88
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.8
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.35
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.35
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.8
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.8
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "boylesports",
                    "title": "BoyleSports",
                    "last_update": "2023-08-06T08:54:49Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:49Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.7
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "leovegas",
                    "title": "LeoVegas",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.8
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.43
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "casumo",
                    "title": "Casumo",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.85
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.45
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.55
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "mrgreen",
                    "title": "Mr Green",
                    "last_update": "2023-08-06T08:55:07Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:07Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.8
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.45
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.55
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "unibet_uk",
                    "title": "Unibet",
                    "last_update": "2023-08-06T08:53:55Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:55Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.85
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.45
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.55
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "matchbook",
                    "title": "Matchbook",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.7
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 3.35
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.74
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.2
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "b3e1f9aa122f041603651e4852f5d64b",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-13T15:30:00Z",
            "home_team": "Chelsea",
            "away_team": "Liverpool",
            "bookmakers": [
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.8
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.75
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.96
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.52
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.65
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 3.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.54
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.7
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.8
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.37
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.8
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.8
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.8
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.75
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.75
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.45
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.8
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.75
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.3
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "boylesports",
                    "title": "BoyleSports",
                    "last_update": "2023-08-06T08:54:49Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:49Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.88
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "leovegas",
                    "title": "LeoVegas",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.9
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.35
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.45
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "casumo",
                    "title": "Casumo",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.95
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "mrgreen",
                    "title": "Mr Green",
                    "last_update": "2023-08-06T08:55:07Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:07Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.95
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "unibet_uk",
                    "title": "Unibet",
                    "last_update": "2023-08-06T08:53:55Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:55Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.95
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.38
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "matchbook",
                    "title": "Matchbook",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.66
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.28
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 3.3
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 2.76
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.3
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "8e9121db01f0d16334c43cf8ff586ca7",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-14T19:00:00Z",
            "home_team": "Manchester United",
            "away_team": "Wolverhampton Wanderers",
            "bookmakers": [
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.33
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 8.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.35
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 8.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.4
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 7.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.36
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 7.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.36
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 7.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.4
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 7.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.33
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 8.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.33
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 8.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.35
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 7.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "boylesports",
                    "title": "BoyleSports",
                    "last_update": "2023-08-06T08:54:49Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:49Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.33
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 8.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "leovegas",
                    "title": "LeoVegas",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.34
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 8.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "casumo",
                    "title": "Casumo",
                    "last_update": "2023-08-06T08:54:47Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:47Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.36
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 8.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "mrgreen",
                    "title": "Mr Green",
                    "last_update": "2023-08-06T08:55:07Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:07Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.35
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 8.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "unibet_uk",
                    "title": "Unibet",
                    "last_update": "2023-08-06T08:53:55Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:55Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.36
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 8.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.33
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 7.75
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.9
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.39
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 9.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.7
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 1.41
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 9.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.8
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "2fb78b696e6dc1929bb00267119613b4",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-18T18:45:00Z",
            "home_team": "Nottingham Forest",
            "away_team": "Sheffield United",
            "bookmakers": [
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Nottingham Forest",
                                    "price": 2.3
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Nottingham Forest",
                                    "price": 2.25
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.25
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Nottingham Forest",
                                    "price": 2.25
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.25
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Nottingham Forest",
                                    "price": 2.2
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Nottingham Forest",
                                    "price": 2.3
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.12
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Nottingham Forest",
                                    "price": 2.2
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.1
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Nottingham Forest",
                                    "price": 2.25
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Nottingham Forest",
                                    "price": 2.25
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Nottingham Forest",
                                    "price": 2.32
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.35
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.35
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Nottingham Forest",
                                    "price": 2.5
                                },
                                {
                                    "name": "Sheffield United",
                                    "price": 3.65
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "7b8fdbe33e70d4b275557cf75082145b",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-19T14:00:00Z",
            "home_team": "Liverpool",
            "away_team": "Bournemouth",
            "bookmakers": [
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 13.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 14.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.18
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 12.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 13.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 6.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 12.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 7.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 13.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.18
                                },
                                {
                                    "name": "Draw",
                                    "price": 7.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 12.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.18
                                },
                                {
                                    "name": "Draw",
                                    "price": 7.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 12.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.18
                                },
                                {
                                    "name": "Draw",
                                    "price": 7.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 15.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.22
                                },
                                {
                                    "name": "Draw",
                                    "price": 7.4
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 17.5
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.25
                                },
                                {
                                    "name": "Draw",
                                    "price": 8.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 15.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 7.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Bournemouth",
                                    "price": 15.0
                                },
                                {
                                    "name": "Liverpool",
                                    "price": 1.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 7.0
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "ae1104f7632d18f6c7b6c68a5d6d8df5",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-19T14:00:00Z",
            "home_team": "Fulham",
            "away_team": "Brentford",
            "bookmakers": [
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.7
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.62
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.75
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.8
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.2
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.7
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.75
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.55
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.7
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.55
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.7
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.55
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.78
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.56
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 3.1
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.78
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.7
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brentford",
                                    "price": 2.7
                                },
                                {
                                    "name": "Fulham",
                                    "price": 2.55
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "2bc2cd0f7e436faf8f6ece40764fb247",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-19T14:00:00Z",
            "home_team": "Wolverhampton Wanderers",
            "away_team": "Brighton and Hove Albion",
            "bookmakers": [
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.85
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 4.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.7
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.91
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 3.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.91
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 4.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.91
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 3.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.91
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 4.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.95
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 3.75
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.85
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 3.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.85
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 3.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.93
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 3.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.75
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 2.0
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 4.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.91
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 4.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Brighton and Hove Albion",
                                    "price": 1.91
                                },
                                {
                                    "name": "Wolverhampton Wanderers",
                                    "price": 3.9
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "1c7a16b35e8ef431ef967f639551d7e6",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-19T16:30:00Z",
            "home_team": "Tottenham Hotspur",
            "away_team": "Manchester United",
            "bookmakers": [
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.38
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.4
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.88
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.4
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.88
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.4
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.88
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.38
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.88
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.38
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.38
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.38
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.38
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.88
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.55
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.56
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 3.25
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.95
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.4
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.87
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Manchester United",
                                    "price": 2.4
                                },
                                {
                                    "name": "Tottenham Hotspur",
                                    "price": 2.87
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "d943c65ea7c431383796cfa689142fcd",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-19T19:00:00Z",
            "home_team": "Manchester City",
            "away_team": "Newcastle United",
            "bookmakers": [
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.4
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 7.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.44
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 6.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.4
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 7.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.4
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 7.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.4
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 7.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.4
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 7.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.4
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 6.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.4
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 6.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.44
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 7.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.8
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.5
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 9.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 5.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.44
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 7.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Manchester City",
                                    "price": 1.44
                                },
                                {
                                    "name": "Newcastle United",
                                    "price": 7.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.33
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "7f42157fb5edc7c8abfd56aa8f4caacd",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-20T13:00:00Z",
            "home_team": "Aston Villa",
            "away_team": "Everton",
            "bookmakers": [
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.67
                                },
                                {
                                    "name": "Everton",
                                    "price": 4.75
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.67
                                },
                                {
                                    "name": "Everton",
                                    "price": 5.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.67
                                },
                                {
                                    "name": "Everton",
                                    "price": 5.25
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.75
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.67
                                },
                                {
                                    "name": "Everton",
                                    "price": 5.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.67
                                },
                                {
                                    "name": "Everton",
                                    "price": 5.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.67
                                },
                                {
                                    "name": "Everton",
                                    "price": 5.25
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.67
                                },
                                {
                                    "name": "Everton",
                                    "price": 4.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.67
                                },
                                {
                                    "name": "Everton",
                                    "price": 4.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.67
                                },
                                {
                                    "name": "Everton",
                                    "price": 5.4
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.82
                                },
                                {
                                    "name": "Everton",
                                    "price": 5.9
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.7
                                },
                                {
                                    "name": "Everton",
                                    "price": 5.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.7
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Aston Villa",
                                    "price": 1.67
                                },
                                {
                                    "name": "Everton",
                                    "price": 5.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.6
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "a7376453e4b97c1abcc3a0c84edac17e",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-20T15:30:00Z",
            "home_team": "West Ham United",
            "away_team": "Chelsea",
            "bookmakers": [
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.0
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.0
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.05
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.75
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.25
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.0
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.75
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.0
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.4
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.0
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.8
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 1.95
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 1.95
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.7
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.1
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.05
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.3
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.0
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 3.85
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.5
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Chelsea",
                                    "price": 2.1
                                },
                                {
                                    "name": "West Ham United",
                                    "price": 4.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.75
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "cb332e62b4c6d7d790cc34e2c848cebf",
            "sport_key": "soccer_epl",
            "sport_title": "EPL",
            "commence_time": "2023-08-21T19:00:00Z",
            "home_team": "Crystal Palace",
            "away_team": "Arsenal",
            "bookmakers": [
                {
                    "key": "williamhill",
                    "title": "William Hill",
                    "last_update": "2023-08-06T08:54:25Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:25Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.53
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 6.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betway",
                    "title": "Betway",
                    "last_update": "2023-08-06T08:55:13Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:13Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.57
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 5.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "sport888",
                    "title": "888sport",
                    "last_update": "2023-08-06T08:53:29Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:53:29Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.57
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 6.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "skybet",
                    "title": "Sky Bet",
                    "last_update": "2023-08-06T08:54:58Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:58Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.55
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 6.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "paddypower",
                    "title": "Paddy Power",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.5
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 6.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betvictor",
                    "title": "Bet Victor",
                    "last_update": "2023-08-06T08:55:01Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:55:01Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.53
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 6.5
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.9
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "livescorebet",
                    "title": "LiveScore Bet",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.53
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 6.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "virginbet",
                    "title": "Virgin Bet",
                    "last_update": "2023-08-06T08:54:09Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:09Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.53
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 6.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "betfair_ex_uk",
                    "title": "Betfair",
                    "last_update": "2023-08-06T08:54:26Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.58
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 5.6
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.8
                                }
                            ]
                        },
                        {
                            "key": "h2h_lay",
                            "last_update": "2023-08-06T08:54:26Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.67
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 7.2
                                },
                                {
                                    "name": "Draw",
                                    "price": 4.7
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "coral",
                    "title": "Coral",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.57
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 6.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.9
                                }
                            ]
                        }
                    ]
                },
                {
                    "key": "ladbrokes_uk",
                    "title": "Ladbrokes",
                    "last_update": "2023-08-06T08:54:19Z",
                    "markets": [
                        {
                            "key": "h2h",
                            "last_update": "2023-08-06T08:54:19Z",
                            "outcomes": [
                                {
                                    "name": "Arsenal",
                                    "price": 1.57
                                },
                                {
                                    "name": "Crystal Palace",
                                    "price": 6.0
                                },
                                {
                                    "name": "Draw",
                                    "price": 3.9
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]
""".trimIndent()