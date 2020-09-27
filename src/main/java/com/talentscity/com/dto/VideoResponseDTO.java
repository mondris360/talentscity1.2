package com.talentscity.com.dto;

import com.talentscity.com.Entities.Comment;
import com.talentscity.com.Entities.Dislike;
import com.talentscity.com.Entities.Like;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoResponseDTO {
    private Long videoID;
    private String category;
    private String description;
    private String title;
    private String srcUrl;
    private Timestamp dateUploaded;
    private  Long totalViews;
    private String UploadedBy;
    private List<Like>  likes = new ArrayList<>();
    private List<Dislike>  dislikes = new ArrayList<>();
    private List<Comment>  comments = new ArrayList<>();

}




