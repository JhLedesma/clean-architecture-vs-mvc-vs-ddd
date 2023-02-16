package cleanarchitecturev2.adapter.repository.adapter

import cleanarchitecturev2.adapter.repository.dao.PersonDao
import ddd.person.domain.Person
import cleanarchitecturev2.core.person.port.PersonRepository
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