package com.talentscity.com.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name ="recentlyViewed")
public class RecentlyViewed {

    @Id
    @GeneratedValue
    private Long ID;

    // Joining  the Videos table and the Users table (foreign key =  videoID)
    @ManyToOne
    @JoinColumn(name = "videoID")
    private Video video;

    @ManyToOne
    @JoinColumn(name ="userID")
    private User user;

    private Timestamp dateViewed =  new Timestamp(System.currentTimeMillis());

    public RecentlyViewed() {}

    public RecentlyViewed(Long ID, Video video, User user, Timestamp dateViewed) {
        this.ID = ID;
        this.video = video;
        this.user = user;
        this.dateViewed = dateViewed;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getDateViewed() {
        return dateViewed;
    }

    public void setDateViewed(Timestamp dateViewed) {
        this.dateViewed = dateViewed;
    }
}
