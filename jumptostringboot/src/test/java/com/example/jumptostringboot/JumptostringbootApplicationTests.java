package com.example.jumptostringboot;

import com.example.jumptostringboot.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JumptostringbootApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void contextLoads() {
    }

}
