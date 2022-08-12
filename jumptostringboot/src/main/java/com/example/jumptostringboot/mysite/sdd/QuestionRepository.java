package com.example.jumptostringboot.mysite.sdd;

import com.example.jumptostringboot.mysite.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
