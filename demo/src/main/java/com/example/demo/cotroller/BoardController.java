package com.example.demo.cotroller;


import com.example.demo.entity.Board;

import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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
    public String boardWritePro(Board board, Model model, MultipartFile file) throws Exception{

        boardService.write(board, file);

        model.addAttribute("message", "글 작성이 완료 되었습니다");
        model.addAttribute("searchUrl","/board/list");

        return "message";
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
//integer id를값을 찾아내서 넘어온 (파라미터)아이디값을 받아서 boardDelete메소드에 담아서 서비스에 보내준 다음에 삭제처리하겠다.//
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }
//---------게시글 수정하기 ---------------//pathVariable 사용해보기
    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id")Integer id, Model model){

        model.addAttribute("board", boardService.boardview(id));

        return "boardmodify";

    }
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id")Integer id, Board board, MultipartFile file) throws Exception{
        //기존의 글 검색(객체를 생성하여)
        Board boardTemp = boardService.boardview(id);
        //기존 글을 가져와서 boardTemp에 덮어 씌우는 것
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp, file);

        return "redirect:/board/list";
    }


}

