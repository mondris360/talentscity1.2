package com.talentscity.com.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    private Timestamp date  = new Timestamp(System.currentTimeMillis());

}
