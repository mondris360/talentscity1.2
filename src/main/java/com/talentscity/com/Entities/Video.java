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


    public Long getVideoID() {
        return videoID;
    }

    public void setVideoID(Long videoID) {
        this.videoID = videoID;
    }

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(Long totalViews) {
        this.totalViews = totalViews;
    }

    public Timestamp getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Timestamp dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Dislike> getDislikes() {
        return dislikes;
    }

    public void setDislikes(List<Dislike> dislikes) {
        this.dislikes = dislikes;
    }
}
