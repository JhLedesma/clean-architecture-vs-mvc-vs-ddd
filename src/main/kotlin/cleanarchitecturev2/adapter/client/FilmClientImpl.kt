package cleanarchitecturev2.adapter.client

import ddd.exception.ClientServerException
import ddd.film.domain.FilmResponse
import cleanarchitecturev2.core.film.port.FilmClient
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate

class FilmClientImpl(
    private val host: String,
    private val apiKey: String,
    private val apiHost: String,
    private val restTemplate: RestTemplate
) : FilmClient {

    override fun getFilmResponse(title: String): FilmResponse {
        val entity = HttpEntity(null, HttpHeaders().also { it.set("x-rapidapi-key", apiKey) }.also { it.set("x-rapidapi-host", apiHost) })

        return restTemplate.exchange("$host/title/find?q=$title", HttpMethod.GET, entity, FilmResponse::class.java).body
            ?: throw ClientServerException("Not exist data for title: $title")
    }
}

