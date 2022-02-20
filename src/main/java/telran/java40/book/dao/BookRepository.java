package telran.java40.book.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.java40.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	Stream<Book> findByAuthorsName(String authorName);

	Stream<Book> findByPublisherPublisherName(String publisherName);
}
