package com.talentscity.com.Controllers;


import com.talentscity.com.Entities.Video;
import com.talentscity.com.Services.ServiceImpl.VideoServiceImpl;
import com.talentscity.com.dto.VideoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/playvideo")
@Controller
public class PlayVideoController {
    @Autowired
    VideoServiceImpl uploadVideoImpl;

    @RequestMapping(method = RequestMethod.GET)
    //method to play the selected video
    public String playVideo(Model model,  @RequestParam(name = "videoID") Long videoID){
        // get the video from the database using the video id
        Video video = uploadVideoImpl.getVideoByID(videoID);
        // create an initialize a response DTO for the video
        VideoResponseDTO videoResponseDTO = new VideoResponseDTO();
        System.out.println(video.getUser());
        videoResponseDTO.setVideoID(video.getVideoID());
        videoResponseDTO.setTotalViews(video.getTotalViews());
        videoResponseDTO.setDescription(video.getDescription());
        videoResponseDTO.setTitle(video.getTitle());
        videoResponseDTO.setSrcUrl(video.getSrcUrl());
        videoResponseDTO.setDateUploaded(video.getDateUploaded());
        videoResponseDTO.setUploadedBy(video.getUser().getFirstName());
        videoResponseDTO.setLikes(video.getLikes());
        videoResponseDTO.setDislikes(video.getDislikes());
        videoResponseDTO.setComments(video.getComments());

        model.addAttribute("video", videoResponseDTO);

        return "playvideo";
    }
}
