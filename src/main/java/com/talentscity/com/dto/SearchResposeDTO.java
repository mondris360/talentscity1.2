package com.talentscity.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

public class SearchResposeDTO {
    private Long videoID;
    private String title;
    private String uploadedBy;
    private Long totalLikes;
    private Timestamp dateUploaded;


    public SearchResposeDTO(Long videoID, String title, String uploadedBy, Long totalLikes, Timestamp dateUploaded) {
        this.videoID = videoID;
        this.title = title;
        this.uploadedBy = uploadedBy;
        this.totalLikes = totalLikes;
        this.dateUploaded = dateUploaded;
    }


    public Long getVideoID() {
        return videoID;
    }

    public void setVideoID(Long videoID) {
        this.videoID = videoID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Long getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Long totalLikes) {
        this.totalLikes = totalLikes;
    }

    public Timestamp getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Timestamp dateUploaded) {
        this.dateUploaded = dateUploaded;
    }
}
