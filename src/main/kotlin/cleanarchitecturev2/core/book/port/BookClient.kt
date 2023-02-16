package cleanarchitecturev2.core.book.port

import ddd.book.domain.BookResponse

interface BookClient {
    fun getBookResponse(isbn: String): BookResponse
}

