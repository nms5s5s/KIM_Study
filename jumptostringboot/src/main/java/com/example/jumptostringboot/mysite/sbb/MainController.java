package com.example.jumptostringboot.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/sbb")
    @ResponseBody
    public String index() {
        return "안녕하세요 소소한 게시판에 오신걸 환영합니다";
    }
    @RequestMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
