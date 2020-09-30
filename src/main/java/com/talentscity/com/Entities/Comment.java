package com.talentscity.com.Entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name ="comments")
public class Comment {

    @Id
    @GeneratedValue
    private Long commentID;

    @ManyToOne
    @JoinColumn(name ="UserID")
    private User user;

    private String comment;

    @ManyToOne
    @JoinColumn(name ="videoID")
    private Video video;

    private Timestamp date =  new Timestamp(System.currentTimeMillis());

    public Comment(Long commentID, User user, String comment, Video video) {
        this.commentID = commentID;
        this.user = user;
        this.comment = comment;
        this.video = video;
    }


    public Comment() {

    }
}
