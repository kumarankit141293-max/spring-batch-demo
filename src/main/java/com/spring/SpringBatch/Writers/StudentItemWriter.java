package com.spring.SpringBatch.Writers;

import com.spring.SpringBatch.Models.Student;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentItemWriter {

    @Bean
    public JpaItemWriter<Student> writer(EntityManagerFactory emf) {
        JpaItemWriter<Student> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(emf);
        return writer;
    }
}
