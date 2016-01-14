package com.blinch.server.main;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * Created by markuskopf on 08/01/16.
 */

@SpringBootApplication
@EnableNeo4jRepositories
public class Application extends Neo4jConfiguration {

    public Application() {
        setBasePackage("com.blinch.server");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("target/hello.db");
    }

    public static void main(String... args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

}
