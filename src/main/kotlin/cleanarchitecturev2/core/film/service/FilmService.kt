package cleanarchitecturev2.core.film.service

import ddd.film.domain.Film
import cleanarchitecturev2.core.film.port.FilmClient

class FilmService(private val filmClient: FilmClient) {

    fun getFilm(title: String): Film =
        filmClient.getFilmResponse(title)
            .results
            .firstOrNull { !it.title.isNullOrEmpty() || !it.titleType.isNullOrEmpty() }
            ?.let {
                Film(
                    title,
                    it.seriesStartYear,
                    it.seriesEndYear,
                    it.numberOfEpisodes,
                    it.runningTimeInMinutes
                )
            }
            ?: throw RuntimeException("Not exist results for title: $title")
}

