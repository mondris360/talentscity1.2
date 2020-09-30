package com.talentscity.com.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name= "likes")
public class Like {
    @Id
    @GeneratedValue
    private Long likeID;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name ="userID")
    private User user;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "videoID")
    private  Video video;

    public Like(User user, Video video) {
        this.user = user;
        this.video = video;
    }

    public Like() {}


    private Timestamp date  = new Timestamp(System.currentTimeMillis());

    public Like(Long likeID, User user, Video video) {
        this.likeID = likeID;
        this.user = user;
        this.video = video;
    }


    public Long getLikeID() {
        return likeID;
    }

    public void setLikeID(Long likeID) {
        this.likeID = likeID;
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
