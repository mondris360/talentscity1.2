package com.talentscity.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequestDTO {
    private MultipartFile videoFile;
    private String category;
    private String description;
    private String title;
}
