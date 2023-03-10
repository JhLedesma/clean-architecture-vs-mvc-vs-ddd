package ddd.film.application

import ddd.film.domain.FilmClient
import ddd.film.domain.Film

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

