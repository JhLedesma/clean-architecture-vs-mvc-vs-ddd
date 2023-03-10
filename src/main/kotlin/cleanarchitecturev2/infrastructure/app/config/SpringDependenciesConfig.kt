package cleanarchitecturev2.infrastructure.app.config

import cleanarchitecturev2.adapter.client.BookClientImpl
import cleanarchitecturev2.adapter.client.FilmClientImpl
import cleanarchitecturev2.adapter.controller.PersonEndpoints
import cleanarchitecturev2.adapter.repository.adapter.ModelMapper
import cleanarchitecturev2.adapter.repository.adapter.PersonAdapterRepository
import cleanarchitecturev2.adapter.repository.dao.PersonDao
import cleanarchitecturev2.core.book.service.BookService
import cleanarchitecturev2.core.film.service.FilmService
import cleanarchitecturev2.core.person.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = ["cleanarchitecturev2"])
class SpringDependenciesConfig (@Autowired private val personDao: PersonDao) {

    @Value("\${book.host}")
    private lateinit var bookHost: String

    @Value("\${film.host}")
    private lateinit var filmHost: String

    @Value("\${film.host_key}")
    private lateinit var filmHostKey: String

    @Value("\${film.api_key}")
    private lateinit var filmApiKey: String

    @Bean
    fun restTemplate(): RestTemplate = RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(10000)).build()

    @Bean
    fun modelMapper() = ModelMapper()

    @Bean
    fun personRepository() = PersonAdapterRepository(personDao, modelMapper())

    @Bean
    fun bookClient() = BookClientImpl(bookHost, restTemplate())

    @Bean
    fun filmClient() = FilmClientImpl(filmHost, filmApiKey, filmHostKey, restTemplate())

    @Bean
    fun bookService() = BookService(bookClient())

    @Bean
    fun filmService() = FilmService(filmClient())

    @Bean
    fun personService() = PersonService(bookService(), filmService(), personRepository())

    @Bean
    fun personController() = PersonEndpoints(personService())
}