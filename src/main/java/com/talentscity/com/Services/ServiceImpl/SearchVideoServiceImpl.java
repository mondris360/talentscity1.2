package com.talentscity.com.Services.ServiceImpl;

import com.talentscity.com.Entities.Video;
import com.talentscity.com.Repositories.SearchVideoRepository;
import com.talentscity.com.Services.SearchVideoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchVideoServiceImpl implements SearchVideoService {
    private  SearchVideoRepository searchVideoRepository;

    public SearchVideoServiceImpl(SearchVideoRepository searchVideoRepository) {
        this.searchVideoRepository = searchVideoRepository;
    }

    @Override
    // method to search for videos
    public List<Video> searchForVideos(String searchword1, String searchword2d) {
        return searchVideoRepository.findByDescriptionIsContainingOrTitleContaining(searchword1, searchword2d);
    }
}
