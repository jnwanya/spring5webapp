package com.jnwanya.spring4webapp.bootstrap;

import com.jnwanya.spring4webapp.model.Author;
import com.jnwanya.spring4webapp.model.Book;
import com.jnwanya.spring4webapp.model.Publisher;
import com.jnwanya.spring4webapp.repositories.AuthorRepository;
import com.jnwanya.spring4webapp.repositories.BookRepository;
import com.jnwanya.spring4webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Jnwanya on
 * Thu, 04 Jan, 2018.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       initData();
    }

    private void initData(){

        Publisher harperPublisher = new Publisher("HarperCollection", "New Jersey, USA");
        publisherRepository.save(harperPublisher);

        Author eric = new Author("Justin", "Nwanya");
        Book ericBook = new Book("Java for Dummies", "1234", harperPublisher);
        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ericBook);
       // authorRepository.save(eric);

        Publisher macPublisher = new Publisher("Macmillain", "New York, USA");
        publisherRepository.save(macPublisher);

        Author rob = new Author("Rob", "Johnson");
        Book robBook = new Book("English as Foreign Language", "0091", macPublisher);
        rob.getBooks().add(robBook);

        authorRepository.save(rob);
        bookRepository.save(robBook);
    }
}
