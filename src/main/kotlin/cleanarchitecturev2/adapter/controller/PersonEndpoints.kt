package cleanarchitecturev2.adapter.controller

import ddd.person.domain.Person
import ddd.person.domain.PersonInput
import cleanarchitecturev2.core.person.service.PersonService

class PersonEndpoints(private val personService: PersonService) {

    fun createPerson(personInput: PersonInput): Person =
        personService.createPerson(personInput)

    fun getPerson(dni: Long): Person =
        personService.getPerson(dni)

    fun getPeople(): List<Person> =
        personService.getPeople()
}

