package ddd.person.domain

interface PersonRepository {

    fun save(person: Person): Person
    fun findByDni(dni: Long): Person?
    fun findAll(): List<Person>
}