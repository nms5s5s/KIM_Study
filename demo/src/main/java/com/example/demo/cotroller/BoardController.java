package com.example.demo.cotroller;


import com.example.demo.entity.Board;

import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BoardController {

//---------------220809 내용 작성 DB에 저장하기
    @Autowired
    private BoardService boardService;
//-----------글 제목 작성틀----------//
    @GetMapping("/board/write")
    public String boardwriterForm(){

        return "boardwrite";
    }
//------------글작성----------//
    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){

        boardService.write(board);

        return "redirect:/board/list";
    }
//-----------글목록-----------//
    @GetMapping("/board/list")
    public String boardList(Model model){

        model.addAttribute("list",boardService.boardList());

        //boardService에서 boardlist를 list라는 이름으로 반환한다는 뜻이다.

        return "boardlist";
    }
//----------게시글 상세 페이지------//
    @GetMapping("/board/view")
    public String boardView(Model model, Integer id){
        //다시 넘겨줄때는 model에 넣어줘야한다.
    model.addAttribute("board",boardService.boardview(id));
        return "boardview";
    }
//----------특정 게시 글 삭제하기---------//
    @GetMapping("board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }
//---------게시글 수정하기 ---------------//
    @GetMapping("/board/modify{id}")
    public String boardModify(@PathVariable("id")Integer id){
        return "boardmodify";
    }
}

