package ddd.film.domain


interface FilmClient {
    fun getFilmResponse(title: String): FilmResponse
}

