package cleanarchitecturev2.core.person.model

import ddd.book.domain.Book
import ddd.film.domain.Film

data class Person(
    val dni: Long,
    val name: String,
    val book: Book,
    val film: Film
)

data class PersonInput(
    val dni: Long,
    val name: String,
    val isbn: String,
    val title: String
)













