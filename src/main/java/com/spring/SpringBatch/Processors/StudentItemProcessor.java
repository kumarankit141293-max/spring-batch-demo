package com.spring.SpringBatch.Processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.spring.SpringBatch.Models.Student;

//ye class StudentItemProcessor Student class ke liye hai jo ItemProcessor interface ko implement karti hai.
// isme hum data ko process karte hai jaise ki data ko transform karna, filter karna etc.
// ye process method ko override karti hai jo Student object ko input ke roop me leti hai aur processed Student object ko return karti hai.
@Component
public class StudentItemProcessor implements ItemProcessor<Student, Student> {
    @Override
    public Student process(Student student) {
        student.setName(student.getName().toUpperCase()); // Example transformation
        return student;
    }
}

