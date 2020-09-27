package com.talentscity.com.Controllers;

import com.talentscity.com.Entities.Video;
import com.talentscity.com.Services.ServiceImpl.VideoServiceImpl;
import com.talentscity.com.dto.VideoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Controller
@RequestMapping("/dashboard/uploadVideo")
public class VideoController {
    @Autowired
    VideoServiceImpl uploadVideoImpl;
    @RequestMapping(method = RequestMethod.GET)
    // display upload video page
    public String showUploadVideoPage() {

        System.out.println(System.getProperty("user.dir"));
        return "uploadVideo";
    }

    //method to  validate and save uploaded videos
    @RequestMapping(method = RequestMethod.POST)
    public String uploadVideo(@ModelAttribute VideoRequestDTO newVideo, Model model, HttpServletRequest request) throws IOException {
        String fileType = newVideo.getVideoFile().getContentType();
        // get the size of the file in MB
        Long fileSizeInMB = newVideo.getVideoFile().getSize()/ 1000000;
        assert fileType != null;
        // valid file type
        if (!fileType.equals("video/mp4") || !fileType.equals("video/mp4") || !fileType.equals("video/mp4")){
            System.out.println("invalid file format");
            model.addAttribute("error", "invalid file format.Please upload mp4, webm or ogg video file");
            return "uploadVideo";
            // if the file size is greater than 1k
        } if (fileSizeInMB > 1000) {
            model.addAttribute("error", "Invalid file size. Max file size is 1GB");
        }

        // SAVE THE VIDEO
        Video saveVideo =  uploadVideoImpl.uploadVideo(newVideo, request);
        if (saveVideo == null) {
            model.addAttribute("error", "Unable to upload Video");
            return "uploadVideo";
        }

        model.addAttribute("error", "Video Uploaded Successfully");
        return "uploadVideo";
    }
}
