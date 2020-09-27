package com.talentscity.com.Services;

import com.talentscity.com.Entities.Like;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import com.talentscity.com.dto.VideoRequestDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Service
public interface VideoService {
    Video uploadVideo(VideoRequestDTO newVideo, HttpServletRequest request) throws IOException;
    List<Video> getAllUploadedVideos();
    List<Video> getUserVideos(BigInteger userID);
    Video getVideoByID(Long videoID);
}
