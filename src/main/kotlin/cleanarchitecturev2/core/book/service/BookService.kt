package cleanarchitecturev2.core.book.service

import ddd.book.domain.Book
import cleanarchitecturev2.core.book.port.BookClient

class BookService(private val bookClient: BookClient) {

    fun getBook(isbn: String): Book =
        bookClient.getBookResponse(isbn)
            .items
            .firstOrNull()
            ?.volumeInfo
            ?.let { Book(isbn, it.title, it.authors.first(), it.publisher, it.publishedDate, it.categories.first()) }
            ?: throw RuntimeException("Not exist Items for isbn: $isbn")
}



