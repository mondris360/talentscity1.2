package com.talentscity.com.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="playlist")
public class Playlist {

     @Id
     @GeneratedValue
     private Long playlistID;

     // joining this table with the user table @  userID column
     @OneToOne
     @JoinColumn(name="userID")
     private User user;

     @ManyToOne
     @JoinColumn(name  = "videoID")
     private Video video;

     private Timestamp dateAdded = new Timestamp(System.currentTimeMillis());


     // constructor
     public Playlist(User user, Video video) {
          this.user = user;
          this.video = video;
     }
}
