package ddd.book.domain

interface BookClient {
    fun getBookResponse(isbn: String): BookResponse
}

