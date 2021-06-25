package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Submission {
    @EmbeddedId
    private int userId;
    @EmbeddedId
    private int challengeId;
    @NotNull
    private float score;
    @CreatedDate
    private Date createdAt;

    @ManyToOne
    private List<Challenge> challenge;

}
