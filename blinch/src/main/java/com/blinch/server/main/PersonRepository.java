package com.blinch.server.main;

import java.util.List;

import com.blinch.server.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by markuskopf on 08/01/16.
 */

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    // TODO: Replace with @Param("name") when Spring Data Neo4j supports names vs. positional arguments
    List<Person> findByLastName(@Param("0") String name);

}
