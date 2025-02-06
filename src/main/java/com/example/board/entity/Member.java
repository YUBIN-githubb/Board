package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "member")
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private Integer age;

    //Entity 어노테이션이 붙은 클래스는 기본 생성자가 필요함!
    public Member () {

    }

    public Member (String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
