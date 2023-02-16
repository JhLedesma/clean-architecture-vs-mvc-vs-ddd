package cleanarchitecturev2.adapter.client

import ddd.book.domain.BookResponse
import cleanarchitecturev2.core.book.port.BookClient
import ddd.exception.ClientServerException
import org.springframework.web.client.RestTemplate

class BookClientImpl(private val host:String, private val restTemplate: RestTemplate): BookClient {

    override fun getBookResponse(isbn: String): BookResponse =
        restTemplate.getForObject("$host/books/v1/volumes?q=isbn:$isbn", BookResponse::class.java)
            ?: throw ClientServerException("Not exist data for isbn: $isbn")
}