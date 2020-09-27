package com.talentscity.com.Entities;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dislikes")
public class Dislike {

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

}
