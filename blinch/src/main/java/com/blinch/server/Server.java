package com.blinch.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by markuskopf on 08/01/16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Server {

//    public static final String DB_NAME = "blinchdev";
//    public static final String PERSON_COLLECTION = "Person";
//    public static final String MONGO_HOST = "localhost";
//    public static final int MONGO_PORT = 27017;

    public static void main(String... args) throws Throwable {
        SpringApplication.run(Server.class, args);

//        try {
//
//            MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
//
//            MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
//
//            Person p = new Person("111", "Markus", "Berlin, Germany");
//
//            mongoOps.insert(p, PERSON_COLLECTION);
//
//            Person p1 = mongoOps.findOne(new Query(Criteria.where("name").is("Markus")), Person.class, PERSON_COLLECTION);
//            List allPersonsInsideDb = mongoOps.findAll(Person.class);
//
//            //System.out.println(p1);
//            //System.out.println("Stop");
//
//            mongoOps.dropCollection(PERSON_COLLECTION);
//            mongo.close();
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
    }


}
