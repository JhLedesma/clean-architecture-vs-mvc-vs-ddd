package cleanarchitecturev2.core.film.port

import ddd.film.domain.FilmResponse


interface FilmClient {
    fun getFilmResponse(title: String): FilmResponse
}

