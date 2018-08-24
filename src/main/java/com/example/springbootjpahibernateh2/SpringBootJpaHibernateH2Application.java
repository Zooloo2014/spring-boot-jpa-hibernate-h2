package com.example.springbootjpahibernateh2;

import com.example.springbootjpahibernateh2.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaHibernateH2Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaHibernateH2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Code to run
        logger.info("Student id 10001 -> {}", repository.findById(10001L));

        logger.info("All users 1 -> {}", repository.findAll());

        // Insert a record
        logger.info("Insert record -> {}", repository.save(new Student("Mickey", "M123456")));

        // Update a record
        logger.info("Update record 10001 -> {}", repository.save(new Student(10001L, "Name Updated", "New Passport")));

        // Delete a record
        repository.deleteById(10002L);

        logger.info("All users 2 -> {}", repository.findAll());
	}

}
