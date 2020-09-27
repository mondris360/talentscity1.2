package com.talentscity.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDTO {
    private Long videoID;
    private String title;
    private String uploadedBy;
    private String srcUrl;
}
