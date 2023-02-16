package ddd.person.application

import ddd.person.domain.Person
import ddd.person.domain.PersonInput

class PersonEndpoints(private val personService: PersonService) {

    fun createPerson(personInput: PersonInput): Person =
        personService.createPerson(personInput)

    fun getPerson(dni: Long): Person =
        personService.getPerson(dni)

    fun getPeople(): List<Person> =
        personService.getPeople()
}

