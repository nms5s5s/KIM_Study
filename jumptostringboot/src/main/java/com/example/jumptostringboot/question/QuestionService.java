package com.example.jumptostringboot.question;

import com.example.jumptostringboot.mysite.sbb.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import java.util.List;
@RequiredArgsConstructor
@Service
public class QuestionService {
        private final QuestionRepository questionRepository;
        public List<Question> getList(){

            return this.questionRepository.findAll();
        }
        public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
        //만약 id 값에 해당하는 Question 데이터가 없을 경우에는 DataNotFoundException을 발생
            throw new DataNotFoundException("question not found");
        }
    }
        public void create(String subject, String content) {
            Question q = new Question();
            q.setSubject(subject);
            q.setContent(content);
            q.setCreateDate(new Date());
            this.questionRepository.save(q);
        }
}
