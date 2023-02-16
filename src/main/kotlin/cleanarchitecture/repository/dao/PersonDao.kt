package cleanarchitecture.repository.dao

import cleanarchitecture.repository.model.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PersonDao : JpaRepository<PersonEntity, Long>