package cleanarchitecturev2.adapter.repository.model

import ddd.person.infrastructure.repository.model.BookEntity
import ddd.person.infrastructure.repository.model.FilmEntity
import javax.persistence.*

@Entity
@Table(name = "person")
data class PersonEntity(
    @Id
    val dni: Long,
    val name: String,
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval=true)
    val book: BookEntity,
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval=true)
    val film: FilmEntity
)