package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Candidate {
    @EmbeddedId
    private int userId;
    @NotNull
    private int status;
    @CreatedDate
    private Date createdAt;
}
