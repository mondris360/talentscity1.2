package com.talentscity.com.Controllers;

import com.talentscity.com.Entities.Dislike;
import com.talentscity.com.Entities.Like;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import com.talentscity.com.Services.ServiceImpl.LikeVideoServiceImpl;
import com.talentscity.com.Services.ServiceImpl.UnlikeVideoServiceImpl;
import com.talentscity.com.Services.ServiceImpl.UserServiceImpl;
import com.talentscity.com.Services.ServiceImpl.VideoServiceImpl;
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

@RequestMapping("/unlikevideo")
@Controller
public class UnlikeVideoController {
    LikeVideoServiceImpl likeVideoServiceImpl;
    UnlikeVideoServiceImpl unlikeVideoServiceImpl;
    UserServiceImpl userServiceImpl;
    VideoServiceImpl videoServiceImpl;

    @Autowired
    public UnlikeVideoController(LikeVideoServiceImpl likeVideoServiceImpl, UnlikeVideoServiceImpl unlikeVideoServiceImpl, UserServiceImpl userServiceImpl, VideoServiceImpl videoServiceImpl) {
        this.likeVideoServiceImpl = likeVideoServiceImpl;
        this.unlikeVideoServiceImpl = unlikeVideoServiceImpl;
        this.userServiceImpl = userServiceImpl;
        this.videoServiceImpl = videoServiceImpl;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String unLike(@RequestParam("videoID") Long videoID, RedirectAttributes redirectAttributes, HttpServletRequest request){
        //  get the http session object
        HttpSession session  = request.getSession();
        // check if the user  is currently logged in
        if (session.getAttribute("user") == null){
            redirectAttributes.addFlashAttribute("error", "Please Login To UnLike This Video");
            session.setAttribute("goto", "playvideo?videoID=" + videoID);
            return "redirect:/login";
        }

        UserDTO UserDTO = (UserDTO) session.getAttribute("user");
        BigInteger userID =  UserDTO.getUserID();
        Video video = videoServiceImpl.getVideoByID(videoID);
        User user =  userServiceImpl.getUserById(userID);


        // check if a user  has already liked the video
        Like getVideoLike =  likeVideoServiceImpl.getUserVideoLike(user, video);
        // check if the user has already liked the video
        if (getVideoLike != null){
            // delete the user like
            likeVideoServiceImpl.deleteLikeEntry(getVideoLike);
        }

        // check if the user  has already unlike the video
        Dislike unlike =  unlikeVideoServiceImpl.getUserUnlikeEntry(user, video);
        if (unlike != null){
            redirectAttributes.addFlashAttribute("error", "You have Already Unlike The Video");
            return "redirect:/playvideo?videoID="+ videoID;
        }
        Dislike unlike2 =  new Dislike(user, video);
        // unlike the video
        unlikeVideoServiceImpl.unlikeVideo(unlike2);
        redirectAttributes.addFlashAttribute("success", "You Have Successful Unlike The Video");
        return "redirect:/playvideo?videoID="+ videoID;

    }
}
