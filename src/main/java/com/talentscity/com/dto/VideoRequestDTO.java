package com.talentscity.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


public class VideoRequestDTO {
    private MultipartFile videoFile;
    private String category;
    private String description;
    private String title;


    public VideoRequestDTO(MultipartFile videoFile, String category, String description, String title) {
        this.videoFile = videoFile;
        this.category = category;
        this.description = description;
        this.title = title;
    }

    public MultipartFile getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(MultipartFile videoFile) {
        this.videoFile = videoFile;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
