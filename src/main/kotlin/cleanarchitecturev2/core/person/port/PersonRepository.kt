package cleanarchitecturev2.core.person.port

import ddd.person.domain.Person

interface PersonRepository {

    fun save(person: Person): Person
    fun findByDni(dni: Long): Person?
    fun findAll(): List<Person>
}