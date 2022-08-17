package com.example.jumptostringboot.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RequiredArgsConstructor는 롬복이 제공하는 애너테이션으로 final이 붙은 속성을 포함하는 생성자를 자동으로 생성하는 역할을 한다.
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
//Question 리포지터리를 사용/
    private final QuestionService questionService;
//-----------------------------------------------
    @RequestMapping("/list")
    public String list(Model model){
    //Question 리포지터리로 조회한 질문 목록은(List) Model 클래스를 사용하여 템플릿에 전달
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
//-----------------------------------------------
    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    @GetMapping("/create")
    public String questionCreate() {
        return "question_form";
    }
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }
}
