package com.example.demo.cotroller;


import com.example.demo.entity.Board;

import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public String boardWritePro(Board board, MultipartFile file, Model model) throws Exception{

        boardService.write(board, file);

        model.addAttribute("message", "글 작성이 완료 되었습니다");
        model.addAttribute("searchUrl","/board/list");

        return "message";
    }
//-----------글목록-----------//---------페이징처리(최신글이 맨 위로 올라오도록)-----------//
    @GetMapping("/board/list")
    //역순으로 정리하겠다 /Pageable은 도메인으로 선택
    public String boardList(Model model, @PageableDefault(page =0, size = 10, sort = "id", direction = Sort.Direction.DESC)
                            Pageable pageable, String searchKeyword){
//----검색했을때와 검색하지않았을때를 구별---//
        Page<Board> list = null;
        if(searchKeyword == null){
            list = boardService.boardList(pageable);
        }else {
            list = boardService.boardSearchList(searchKeyword, pageable);
        }

//--------------페이징처리-----------------//
        //변수선언
        //기존 페이지를 가져오겠다
        int nowPage = list.getPageable().getPageNumber();
        //두값을 비교해서 큰수를 반환하겠다(-4를 했을때 1보다 작으면 1을 반환하겠다는 조건 나우페이지가 1이면 -3이 나오므로)
        int startPage = Math.max(nowPage -4, 1);
        //토탈 페이지가 10페이지인데 나우 페이지가 9이면 +5를 하면 14 페이지 이므로 토탈 페이지를 반환할 수있게 Math.min을 사용
        int endPage = Math.min(nowPage +5, list.getTotalPages());

        model.addAttribute("list",list);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

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

    //----------특정 게시 글 삭제하기---------//
    @GetMapping("board/delete")
    public String boardDelete(Integer id){
//integer id를값을 찾아내서 넘어온 (파라미터)아이디값을 받아서 boardDelete메소드에 담아서 서비스에 보내준 다음에 삭제처리하겠다.//
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

}

