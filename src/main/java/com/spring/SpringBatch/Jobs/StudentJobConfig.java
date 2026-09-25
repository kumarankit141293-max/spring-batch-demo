package com.spring.SpringBatch.Jobs;

import com.spring.SpringBatch.Models.Student;
import com.spring.SpringBatch.Processors.StudentItemProcessor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StudentJobConfig {

    @Bean
    // yaha pe Job ko configure kar rahe hai jisme reader, processor aur writer ko inject kiya ja raha hai
    public Job studentJob(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager,
                          ItemReader<Student> reader,
                          StudentItemProcessor processor,
                          ItemWriter<Student> writer) {
        //yaha pe Step ko configure kar rahe hai jisme reader, processor aur writer ko inject kiya ja raha hai
        //step matlab ek unit of work hai jisme reader, processor aur writer ko execute kiya ja raha hai
        //stepBuilder ka use karke step ko configure kar rahe hai jisme chunk size 10 hai aur transaction manager ko inject kiya ja raha hai
        Step step = new StepBuilder("student-step", jobRepository)
                .<Student, Student>chunk(10, transactionManager)  // ✅ new API
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

        //ye JobBuilder ka use karke job ko configure kar rahe hai jisme step ko inject kiya ja raha hai aur
        // start method ka use karke job ko start kar rahe hai aur build method ka use karke job ko build kar rahe hai
        return new JobBuilder("student-job", jobRepository)
                .start(step)
                .build();
    }
}

