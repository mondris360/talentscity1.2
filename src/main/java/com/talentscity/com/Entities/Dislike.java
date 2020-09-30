package com.talentscity.com.Entities;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "dislikes")
public class Dislike {

    public Dislike(Long id, User user, Video video, Timestamp date) {
        this.id = id;
        this.user = user;
        this.video = video;
        this.date = date;
    }
    public  Dislike(){}

    @Id
    @GeneratedValue
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "videoID")
    private Video video;

    public Dislike(User user, Video video) {
        this.user = user;
        this.video = video;
    }

    private Timestamp date =  new Timestamp(System.currentTimeMillis());

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
