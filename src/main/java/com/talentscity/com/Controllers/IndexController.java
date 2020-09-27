package com.talentscity.com.Controllers;

import com.talentscity.com.Entities.Video;
import com.talentscity.com.Services.ServiceImpl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class IndexController {
   @Autowired
   VideoServiceImpl uploadVideo;
    @GetMapping("/")
    public String showHomePage(Model model){
        List<Video> uploadedVideos = uploadVideo.getAllUploadedVideos();
        //  send the List to the index page
        model.addAttribute("videos", uploadedVideos);

        return "index";
    }
}
