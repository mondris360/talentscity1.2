package com.talentscity.com.dto;


public class PlaylistDTO {
    private Long videoID;
    private String title;
    private String uploadedBy;
    private String srcUrl;


    public PlaylistDTO(Long videoID, String title, String uploadedBy, String srcUrl) {
        this.videoID = videoID;
        this.title = title;
        this.uploadedBy = uploadedBy;
        this.srcUrl = srcUrl;
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

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }
}
