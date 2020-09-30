package com.talentscity.com.Entities;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue
    private Long categoryID;
    private String name;
    private Timestamp dateCreated =  new Timestamp(System.currentTimeMillis());
    private int totalViews =  0;

//    @ManyToOne
//    JoinColumn(name = "videoID");
//    private Video video;
    @ManyToMany
    @JoinColumn(name="videoID")
    private List<Video> video;


    public Category(Long categoryID, String name, int totalViews, List<Video> video) {
        this.categoryID = categoryID;
        this.name = name;
        this.totalViews = totalViews;
        this.video = video;
    }

    public Category() {
    }
}
