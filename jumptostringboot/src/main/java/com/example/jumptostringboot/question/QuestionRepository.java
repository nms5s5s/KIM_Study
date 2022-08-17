package com.example.jumptostringboot.question;

import com.example.jumptostringboot.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
