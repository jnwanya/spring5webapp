package com.jnwanya.spring4webapp.repositories;

import com.jnwanya.spring4webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jnwanya on
 * Thu, 04 Jan, 2018.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
