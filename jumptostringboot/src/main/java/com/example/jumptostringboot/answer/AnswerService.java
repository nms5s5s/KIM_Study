package com.example.jumptostringboot.answer;

import com.example.jumptostringboot.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        //dbeaver : new date
        answer.setCreateDate(new Date());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }
}
