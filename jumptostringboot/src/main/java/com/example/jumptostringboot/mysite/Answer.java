package com.example.jumptostringboot.mysite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

//답변 엔티티 생성
@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String content;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date createDate;

    @ManyToOne
    private Question question;
}
