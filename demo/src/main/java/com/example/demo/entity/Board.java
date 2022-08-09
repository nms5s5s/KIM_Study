package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    private String title;

    private String content;
}
