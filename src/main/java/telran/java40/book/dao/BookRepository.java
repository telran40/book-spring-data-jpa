package telran.java40.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.java40.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
