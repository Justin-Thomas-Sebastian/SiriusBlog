package com.codeup.springblog.repositories;

import javax.persistence.*;

@Entity
@Table(name="Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;
}
