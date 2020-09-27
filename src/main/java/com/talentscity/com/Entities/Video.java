package com.talentscity.com.Entities;

//  db table for videos

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="videos")
public class Video {

    @Id
    @GeneratedValue
    private  Long videoID;
    private  String srcUrl;
    private  String title;
    @Column(length = 1000)
    private  String description;
    private  Long totalViews = 0L;
    private Timestamp dateUploaded =   new Timestamp(System.currentTimeMillis());
    // overloaded constructor

    public Video(String title, String description, String srcUrl, User user) {
        this.srcUrl = srcUrl;
        this.title = title;
        this.description = description;
        this.user =  user;
    }

    @ManyToOne
    @JoinColumn(name="userID")
    private User user;

    @ManyToMany(mappedBy = "video", cascade = CascadeType.ALL)
    private List<Category> category;

      // map this table to the comment table
     @OneToMany(mappedBy ="video", cascade = CascadeType.ALL)
      private List<Comment> comments = new ArrayList<>();

//      map this table with the likes Table
     @OneToMany(mappedBy ="video", cascade = CascadeType.ALL)
     List<Like> likes = new ArrayList<>();
    
     // map this table with the  dislikes table
     @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    private List<Dislike> dislikes = new ArrayList<>();

}
