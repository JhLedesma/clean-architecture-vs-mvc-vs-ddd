package cleanarchitecturev2.adapter.repository.dao

import ddd.person.infrastructure.repository.model.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PersonDao : JpaRepository<PersonEntity, Long>