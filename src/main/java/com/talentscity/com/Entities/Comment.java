package com.talentscity.com.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="comments")
public class Comment {

    @Id
    @GeneratedValue
    private Long commentID;

    @ManyToOne
    @JoinColumn(name ="UserID")
    private User user;

    private String comment;

    @ManyToOne
    @JoinColumn(name ="videoID")
    private Video video;

    private Timestamp date =  new Timestamp(System.currentTimeMillis());


}
