package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
//---------글작성-----------//
    public void write(Board board, MultipartFile file) throws Exception{
//저장될 공간
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
//파일에 붙이 이름을 랜덤으로
        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();
//랜덤으로 붙이고 파일 이름을 붙여서 파일 이름을 생성해준다.
        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        board.setFilename(fileName);

        board.setFilepath("/files/" + fileName);

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


