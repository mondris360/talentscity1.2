package com.talentscity.com.Entities;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
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

     public Playlist(Long playlistID, User user, Video video) {
          this.playlistID = playlistID;
          this.user = user;
          this.video = video;
     }

     public Playlist() {

     }

     public Long getPlaylistID() {
          return playlistID;
     }

     public void setPlaylistID(Long playlistID) {
          this.playlistID = playlistID;
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

     public Timestamp getDateAdded() {
          return dateAdded;
     }

     public void setDateAdded(Timestamp dateAdded) {
          this.dateAdded = dateAdded;
     }
}
