package com.jnwanya.spring4webapp.repositories;

import com.jnwanya.spring4webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jnwanya on
 * Thu, 04 Jan, 2018.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
