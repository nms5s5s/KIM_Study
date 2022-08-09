package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
//---------글작성-----------//
    public void write(Board board){

        boardRepository.save(board);
    }
//---------게시글 리스트-----------//
    public List<Board> boardList(){
        return boardRepository.findAll();
    }
//---------게시 글 상세페이지-----------//
    public Board boardview(Integer id){
        //findById() 괄호안에 integer를 넣어줘야한다. 즉 페이지수를 선택하여 보겠다라는 뜻이다.
        return boardRepository.findById(id).get();
    }
//---------특정 게시글 삭제하기--------//
    public void boardDelete(Integer id){

        boardRepository.deleteById(id);
    }
}


