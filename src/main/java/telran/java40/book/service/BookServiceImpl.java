package telran.java40.book.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.java40.book.dao.AuthorRepository;
import telran.java40.book.dao.BookRepository;
import telran.java40.book.dao.PublisherRepository;
import telran.java40.book.dto.AuthorDto;
import telran.java40.book.dto.BookDto;
import telran.java40.book.model.Author;
import telran.java40.book.model.Book;
import telran.java40.book.model.Publisher;

@Service
public class BookServiceImpl implements BookService {
	BookRepository bookRepository;
	AuthorRepository authorRepository;
	PublisherRepository publisherRepository;
	ModelMapper modelMapper;

	@Autowired
	public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository,
			PublisherRepository publisherRepository, ModelMapper modelMapper) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean addBook(BookDto bookDto) {
		if(bookRepository.existsById(bookDto.getIsbn())) {
			return false;
		}
		//Publisher
		Publisher publisher = publisherRepository.findById(bookDto.getPublisher())
				.orElse(publisherRepository.save(new Publisher(bookDto.getPublisher())));
		//Authors
		Set<Author> authors = bookDto.getAuthors().stream()
								.map(a -> authorRepository.findById(a.getName())
										.orElse(authorRepository.save(new Author(a.getName(), a.getBirthDate()))))
								.collect(Collectors.toSet());
		Book book = new Book(bookDto.getIsbn(), bookDto.getTitle(), authors, publisher );
		bookRepository.save(book);
		return true;
	}

	@Override
	public BookDto findBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDto removeBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDto updateBook(String isbn, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<BookDto> findBooksByAuthor(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<BookDto> findBooksByPublisher(String publisherName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<AuthorDto> findBookAuthors(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<String> findPublishersByAuthor(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthorDto removeAuthor(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

}
