package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 100)
    @NotNull
    private String fullName;
    @Size(max = 100)
    @Email
    @NotNull
    private String email;
    @NotNull
    @Size(max = 50)
    private String nickname;
    @NotNull
    @Size(max = 255)
    private String password;
    @CreatedDate
    private Date createdAt;

    @OneToMany
    private List<Candidate> candidates;

    @OneToMany
    private List<Submission> submissions;

}
