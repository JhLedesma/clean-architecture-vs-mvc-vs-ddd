package ddd.person.infrastructure.controller

import ddd.person.domain.Person
import ddd.person.domain.PersonInput
import ddd.person.application.PersonEndpoints
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class SpringPersonController(@Autowired private val personEndpoints: PersonEndpoints) {

    @PostMapping("/people")
    fun createPerson(@RequestBody personInput: PersonInput) =
        personEndpoints.createPerson(personInput)

    @GetMapping("/people/{dni}")
    fun getPerson(@PathVariable dni: Long): Person =
        personEndpoints.getPerson(dni)

    @GetMapping("/people")
    fun getPeople(): List<Person> =
        personEndpoints.getPeople()
}