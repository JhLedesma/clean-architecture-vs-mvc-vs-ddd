package ddd.person.infrastructure.repository.adapter

import ddd.person.domain.Person
import ddd.person.domain.PersonRepository
import ddd.person.infrastructure.repository.dao.PersonDao
import org.springframework.data.repository.findByIdOrNull

class PersonAdapterRepository(private val personDao: PersonDao, private val modelMapper: ModelMapper):
    PersonRepository {

    override fun save(person: Person): Person {
        return personDao.save(modelMapper.toEntity(person)).let { modelMapper.toDto(it) }
    }

    override fun findByDni(dni: Long): Person? {
        return personDao.findByIdOrNull(dni)?.let { modelMapper.toDto(it) }
    }

    override fun findAll(): List<Person> {
        return personDao.findAll().map { modelMapper.toDto(it) }
    }
}