package ddd.book.infrastructure.configuration

import ddd.book.application.BookService
import ddd.book.domain.BookClient
import ddd.book.infrastructure.client.BookClientImpl
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
@ComponentScan(basePackages = ["ddd"])
class BookBeans {

    @Value("\${book.host}")
    private lateinit var bookHost: String

    @Bean
    fun restTemplate(): RestTemplate = RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(10000)).build()

    @Bean
    fun bookClient(restTemplate: RestTemplate) = BookClientImpl(bookHost, restTemplate)

    @Bean
    fun bookService(bookClient: BookClient) = BookService(bookClient)
}