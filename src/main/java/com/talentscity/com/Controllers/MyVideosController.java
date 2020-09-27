package com.talentscity.com.Controllers;

import com.talentscity.com.Entities.Video;
import com.talentscity.com.Services.ServiceImpl.VideoServiceImpl;
import com.talentscity.com.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/dashboard/myvideoes")
public class MyVideosController {
    @Autowired
    VideoServiceImpl uploadVideo;

    @RequestMapping(method = RequestMethod.GET)
    // method to get and display videos uploaded by a particular user
    public String displayUsersVideos(Model model, HttpServletRequest request) {
        HttpSession session =  request.getSession();
        UserDTO user  = (UserDTO) session.getAttribute("user");
        BigInteger userID  =  user.getUserID();
        List<Video> getUserVideos =  uploadVideo.getUserVideos(userID);
        model.addAttribute("myvideos", getUserVideos);
        System.out.println(getUserVideos);

        return "myvideos";
    }

}
