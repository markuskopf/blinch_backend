package com.blinch.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServerApplication {


	//    public static final String DB_NAME = "test";
//    public static final String PERSON_COLLECTION = "Customer";
//    public static final String MONGO_HOST = "localhost";
//    public static final int MONGO_PORT = 27017;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);

//		try {
//
//            MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
//
//            MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
//
//            Customer p = new Customer("Manual", "Created");
//
//            mongoOps.insert(p, PERSON_COLLECTION);
//
//            Customer p1 = mongoOps.findOne(new Query(Criteria.where("firstName").is("Manual")), Customer.class, PERSON_COLLECTION);
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
