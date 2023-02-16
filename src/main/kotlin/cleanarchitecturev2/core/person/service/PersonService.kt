package cleanarchitecturev2.core.person.service

import cleanarchitecturev2.core.book.service.BookService
import cleanarchitecturev2.core.film.service.FilmService
import ddd.person.domain.Person
import ddd.person.domain.PersonInput
import cleanarchitecturev2.core.person.port.PersonRepository

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

