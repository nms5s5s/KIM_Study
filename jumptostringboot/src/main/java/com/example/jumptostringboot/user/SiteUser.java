package com.example.jumptostringboot.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class SiteUser {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;

        @Column(unique = true)
        private String username;

        private String password;

        @Column(unique = true)
        private String email;
}
