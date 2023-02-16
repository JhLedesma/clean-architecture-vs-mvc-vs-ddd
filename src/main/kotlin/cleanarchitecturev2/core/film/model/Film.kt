package cleanarchitecturev2.core.film.model

import ddd.film.domain.Result

data class Film(
    val title: String,
    val seriesStartYear: Int,
    val seriesEndYear: Int,
    val numberOfEpisodes: Int,
    val runningTimeInMinutes: Int,
    val id: Long? = null
)

data class FilmResponse(
    val query: String,
    val results: List<Result>
)

data class Result(
    val id: String,
    val numberOfEpisodes: Int,
    val runningTimeInMinutes: Int,
    val seriesEndYear: Int,
    val seriesStartYear: Int,
    val title: String?,
    val titleType: String?
)


