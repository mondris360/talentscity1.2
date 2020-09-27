package com.talentscity.com.Controllers;

import com.talentscity.com.Entities.Playlist;
import com.talentscity.com.Entities.Video;
import com.talentscity.com.Services.SearchVideoService;
import com.talentscity.com.Services.ServiceImpl.SearchVideoServiceImpl;
import com.talentscity.com.dto.PlaylistDTO;
import com.talentscity.com.dto.SearchRequestDTO;
import com.talentscity.com.dto.SearchResposeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search")
public class searchController {

    private SearchVideoServiceImpl searchVideosServiceImpl;

    public searchController(SearchVideoServiceImpl searchVideosServiceImpl) {
        this.searchVideosServiceImpl = searchVideosServiceImpl;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showSearchPage(Model model){

        return"search";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String displaySearchResult(@Valid SearchRequestDTO searchWord, Model model){

        List<Video> searchResult = searchVideosServiceImpl.searchForVideos(searchWord.getSearchWord(), searchWord.getSearchWord());
        // search a searchRespose with the returned result
        List<SearchResposeDTO> searchResultDTO =  new ArrayList<>();
        for (Video video: searchResult ){
            Long videoID =  video.getVideoID();
            String  title =  video.getTitle();
            String  uploadedBy =  video.getUser().getFirstName();
            Long  totalLikes =  (long)video.getLikes().size();
            Timestamp dateUploaded =  video.getDateUploaded();
            SearchResposeDTO resultResult =  new SearchResposeDTO(videoID,title,uploadedBy,totalLikes,dateUploaded);
            searchResultDTO.add(resultResult);
        }
        System.out.println("======================= "  +  searchResultDTO);
        model.addAttribute("searchResult", searchResultDTO);

        return"search";
    }
}
