package com.talentscity.com.Services;

import com.talentscity.com.Entities.Video;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchVideoService {
    List<Video> searchForVideos(String searchword1, String searchword2);
}
