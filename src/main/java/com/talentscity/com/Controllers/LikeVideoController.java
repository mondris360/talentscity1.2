package com.talentscity.com.Controllers;


import com.talentscity.com.Entities.Dislike;
import com.talentscity.com.Entities.Like;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import com.talentscity.com.Services.ServiceImpl.LikeVideoServiceImpl;
import com.talentscity.com.Services.ServiceImpl.UnlikeVideoServiceImpl;
import com.talentscity.com.Services.ServiceImpl.VideoServiceImpl;
import com.talentscity.com.Services.ServiceImpl.UserServiceImpl;
import com.talentscity.com.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.Principal;
import java.sql.SQLOutput;


@RequestMapping("/likevideo")
@Controller
public class LikeVideoController {
    LikeVideoServiceImpl likeVideoServiceImpl;
    UnlikeVideoServiceImpl unlikeVideoServiceImpl;
    UserServiceImpl userServiceImpl;
    VideoServiceImpl videoServiceImpl;

    @Autowired
    public LikeVideoController(LikeVideoServiceImpl likeVideoServiceImpl, UnlikeVideoServiceImpl unlikeVideoServiceImpl, UserServiceImpl userServiceImpl, VideoServiceImpl videoServiceImpl) {
        this.likeVideoServiceImpl = likeVideoServiceImpl;
        this.unlikeVideoServiceImpl = unlikeVideoServiceImpl;
        this.userServiceImpl = userServiceImpl;
        this.videoServiceImpl = videoServiceImpl;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String likeAVideo(@RequestParam("videoID") Long videoID, RedirectAttributes redirectAttributes, HttpServletRequest request){
        //  get the http session object
        HttpSession session  = request.getSession();
        Principal currentUser =  request.getUserPrincipal();
        // check if the user  is currently logged in
        if (currentUser == null){
            redirectAttributes.addFlashAttribute("error", "Please Login To Like This Video");
            return "redirect:/playvideo?videoID="+ videoID;
        }

        User principal = (User) request.getUserPrincipal();
        System.out.println("Inside Like principal=====" +  principal);
        BigInteger userID =  principal.getUserID();
        System.out.println("Principal ID" + userID);
        User user = userServiceImpl.getUserById(userID);
        Video video = videoServiceImpl.getVideoByID(videoID);

        // check if a user  has already liked the video
        Like getVideoLike =  likeVideoServiceImpl.getUserVideoLike(user, video);
        if (getVideoLike != null){
            redirectAttributes.addFlashAttribute("error", "You Have Already Liked The Video");
            return "redirect:/playvideo?videoID="+ videoID;
        }

        // check  if the user has already unlike the video
        Dislike getUnlikeRecord =  unlikeVideoServiceImpl.getUserUnlikeEntry(user, video);
        if (getUnlikeRecord != null) {
            // delete the unlike record
            unlikeVideoServiceImpl.deleteVideoUnlikeRecord(getUnlikeRecord);
        }

        // save the user like
        likeVideoServiceImpl.likeVideo(user, video);
        redirectAttributes.addFlashAttribute("success", "Video Liked");
        return "redirect:/playvideo?videoID="+ videoID;

    }
}
