package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(max = 50)
    private String slug;
    @CreatedDate
    private Date createdAt;

    @OneToMany
    private List<Candidate> candidates;

}
