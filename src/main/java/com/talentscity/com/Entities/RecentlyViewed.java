package com.talentscity.com.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
