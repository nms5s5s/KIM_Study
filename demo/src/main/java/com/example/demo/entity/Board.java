package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//엔티티는 테이블을 의미
@Entity
//테이블을 의미한다.
@Data
//borard controller 에서 public String boardWritePro(String title, String content) ()소괄호 안에 하나하나 써주기 힘들기 때문에
//Board board 를 작성하여 Board안에 타이틀을 받아줄수 있다.
public class Board {

    @Id
    //프라이머리티를 의미//
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //identity : my sql에서 사용할때
    //sequence : oracle 에서 사용
    private Integer id;
// 글 제목
    private String title;
// 글 내용
    private String content;
// 글 작성자
    private String writer;
// 글 등록일
    private Date createDate;
// 조회수
    private Long cnt;
//첨부파일 이름
    private String filename;
//첨부파일 경로
    private String filepath;

}
