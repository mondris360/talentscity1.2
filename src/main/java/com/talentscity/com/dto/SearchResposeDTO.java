package com.talentscity.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResposeDTO {
    private Long videoID;
    private String title;
    private String uploadedBy;
    private Long totalLikes;
    private Timestamp dateUploaded;

}
