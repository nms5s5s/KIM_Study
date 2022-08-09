//package com.example.demo.service;
//
//import java.util.List;
//
//import com.example.demo.domain.Board;
//import com.example.demo.persistence.BoardRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BoardServiceImpl implements BoardService {
//    @Autowired
//    private BoardRepository boardRepo;
//
//    public List<Board> getBoardList(Board board) {
//        return (List<Board>) boardRepo.findAll();
//    }
//    @Override
//    public void insertBoard(Board board){
//        boardRepo.save(board);
//    }
//
//    @Override
//    public Board getBoard(Board board){
//        return boardRepo.findById(board.getSeq()).get();
//    }
//
//    @Override
//    public void updateBoard(Board board) {
//        Board findBoard = boardRepo.findById(board.getSeq()).get();
//
//        findBoard.setTitle(board.getTitle());
//        findBoard.setContent(board.getContent());
//        boardRepo.save(findBoard);
//
//    }
//
//    @Override
//    public void deleteBoard(Board board) {
//        boardRepo.deleteById(board.getSeq());
//
//    }
//}
