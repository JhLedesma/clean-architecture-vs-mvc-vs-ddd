package ddd.book.infrastructure.client

import ddd.book.domain.BookClient
import ddd.book.domain.BookResponse
import ddd.exception.ClientServerException
import org.springframework.web.client.RestTemplate

class BookClientImpl(private val host:String, private val restTemplate: RestTemplate): BookClient {

    override fun getBookResponse(isbn: String): BookResponse =
        restTemplate.getForObject("$host/books/v1/volumes?q=isbn:$isbn", BookResponse::class.java)
            ?: throw ClientServerException("Not exist data for isbn: $isbn")
}