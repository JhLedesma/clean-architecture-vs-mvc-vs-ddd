package ddd.person.infrastructure.configuration

import ddd.person.infrastructure.repository.adapter.PersonAdapterRepository
import ddd.book.application.BookService
import ddd.film.application.FilmService
import ddd.person.application.PersonEndpoints
import ddd.person.application.PersonService
import ddd.person.domain.PersonRepository
import ddd.person.infrastructure.repository.adapter.ModelMapper
import ddd.person.infrastructure.repository.dao.PersonDao
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("ddd")
@EntityScan("ddd")
@ComponentScan(basePackages = ["ddd"])
class PersonBeans {

    @Bean
    fun modelMapper() = ModelMapper()

    @Bean
    fun personRepository(modelMapper: ModelMapper, personDao: PersonDao) =
        PersonAdapterRepository(personDao, modelMapper)

    @Bean
    fun personService(bookService: BookService, filmService: FilmService, personRepository: PersonRepository) =
        PersonService(bookService, filmService, personRepository)

    @Bean
    fun personController(personService: PersonService) = PersonEndpoints(personService)
}