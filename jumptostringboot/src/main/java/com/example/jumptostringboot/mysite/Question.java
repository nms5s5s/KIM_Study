package com.example.jumptostringboot.mysite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String subject;

    private String content;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date createDate;
    //답변은 하나의 질문에 여러개가 달리수 있는 구조이다.n:1 관계라고 할수있다.
    //@ManyToOne 애너테이션을 설정하면 Answer 엔티티의 question속성과 Question엔티티가 서로 연결된다.
    //반대방향으로 Question엔티티에서 Answer엔티티를 참조하려면 @OneToMany애너테이션을 사용한다.
    //Question하나에 Answer여러개이므로 Question엔티티에 추가할 답변의 속성은 List형태로 구성해야한다.
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
