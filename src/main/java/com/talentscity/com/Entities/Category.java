package com.talentscity.com.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
