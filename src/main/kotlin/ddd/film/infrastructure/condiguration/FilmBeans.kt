package ddd.film.infrastructure.condiguration

import ddd.film.application.FilmService
import ddd.film.domain.FilmClient
import ddd.film.infrastructure.client.FilmClientImpl
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = ["ddd"])
class FilmBeans {

    @Value("\${film.host}")
    private lateinit var filmHost: String

    @Value("\${film.host_key}")
    private lateinit var filmHostKey: String

    @Value("\${film.api_key}")
    private lateinit var filmApiKey: String

    @Bean
    fun filmClient(restTemplate: RestTemplate) = FilmClientImpl(filmHost, filmApiKey, filmHostKey, restTemplate)

    @Bean
    fun filmService(filmClient: FilmClient) = FilmService(filmClient)
}