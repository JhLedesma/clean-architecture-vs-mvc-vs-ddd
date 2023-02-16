package ddd.person.application

import ddd.book.application.BookService
import ddd.film.application.FilmService
import ddd.person.domain.Person
import ddd.person.domain.PersonInput
import ddd.person.domain.PersonRepository

class PersonService(
    private val bookService: BookService,
    private val filmService: FilmService,
    private val personRepository: PersonRepository
) {

    fun createPerson(personInput: PersonInput): Person {
        val book = bookService.getBook(personInput.isbn)
        val film = filmService.getFilm(personInput.title)

        return personRepository.save(Person(personInput.dni, personInput.name, book, film))
    }

    fun getPerson(dni: Long): Person =
        personRepository.findByDni(dni)
            ?: throw RuntimeException("Not found person for dni: $dni")

    fun getPeople(): List<Person> =
        personRepository.findAll()
}

