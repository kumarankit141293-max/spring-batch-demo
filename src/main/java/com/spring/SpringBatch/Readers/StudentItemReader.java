package com.spring.SpringBatch.Readers;

import com.spring.SpringBatch.Models.Student;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class StudentItemReader {
    @Bean
    public FlatFileItemReader<Student> csvReader() {
        FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
        // src/main/resources/users_100.csv को पढ़ेगा
        reader.setResource(new ClassPathResource("users_100.csv"));
        reader.setLinesToSkip(1); // header skip करेगा
        reader.setLineMapper(new DefaultLineMapper<Student>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("id", "name", "email", "age");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {{
                setTargetType(Student.class);
            }});
        }});
        return reader;
    }
}

