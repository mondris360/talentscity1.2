package com.talentscity.com.Controllers;

import com.talentscity.com.Entities.Playlist;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import com.talentscity.com.Services.ServiceImpl.PlaylistServiceImpl;
import com.talentscity.com.Services.ServiceImpl.UserServiceImpl;
import com.talentscity.com.Services.ServiceImpl.VideoServiceImpl;
import com.talentscity.com.dto.PlaylistDTO;
import com.talentscity.com.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PlaylistController {

    // Dependencies
     private PlaylistServiceImpl playlistImpl;
     private UserServiceImpl userServiceImpl;
     private VideoServiceImpl videoServiceImpl;
     // constructor
    @Autowired
    public PlaylistController(PlaylistServiceImpl playlistImpl, UserServiceImpl userServiceImpl, VideoServiceImpl videoServiceImpl) {
        this.playlistImpl = playlistImpl;
        this.userServiceImpl = userServiceImpl;
        this.videoServiceImpl = videoServiceImpl;
    }

    @GetMapping("viewplaylist")
    // method to display a user playlist
    public String showUserPlayList( @RequestParam("videoID") Long videoID, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        HttpSession session =  request.getSession();
        //if the user does not have an active session
        if (session.getAttribute("user") == null){
            redirectAttributes.addFlashAttribute("error", "Please Login To View Your PlayList");
            session.setAttribute("goto", "playvideo?videoID=" + videoID);
            return "redirect:/login";
        }
        // get the user playList
        UserDTO  user = (UserDTO) session.getAttribute("user");
        BigInteger userID =  user.getUserID();
        List<Playlist> userPlaylistItems =  playlistImpl.getUserPlayList(userID);
         // create  a playlistDTO from the returned result
        List<PlaylistDTO> myPlaylist =  new ArrayList<>();
        for (Playlist playlist: userPlaylistItems ){
            Long videoID1 =  playlist.getVideo().getVideoID();
            String  title =  playlist.getVideo().getTitle();
            String  uploadedBy =  playlist.getUser().getFirstName();
            String srcUrl =  playlist.getVideo().getSrcUrl();
            PlaylistDTO playlistDTO =  new PlaylistDTO(videoID1, title, uploadedBy, srcUrl);
            myPlaylist.add(playlistDTO);
        }
        redirectAttributes.addFlashAttribute("videos", myPlaylist);
        redirectAttributes.addFlashAttribute("menuTitle", "My PlayList");

       return "redirect:playvideo?videoID=" + videoID;
    }


    @GetMapping("addtoplaylist")
    // method to add video to a user playlist
    public String addVideoToMyPlaylist(@RequestParam("videoID") Long videoID, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        // check if the user  has an active session
        HttpSession session  = request.getSession();
        if (session.getAttribute("user") == null){
            redirectAttributes.addFlashAttribute("error", "Please login to add a video to your playlist");
            // member the page the user was and redirect him/her to the page after login
            session.setAttribute("goto", "playvideo?videoID=" + videoID);
            return "redirect:/login";
        }

        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        BigInteger userID =  userDTO.getUserID();
        // get the user from the db using the  user id
        User user = userServiceImpl.getUserById(userID);
        Video video = videoServiceImpl.getVideoByID(videoID);
        // check if the user has already added the video to his/her playlist
        Playlist videoExistsInPlaylist = playlistImpl.getVideoFromUserPlaYList(user, video);

        // check if the video already exists in  user playlist
        if (videoExistsInPlaylist != null){
            redirectAttributes.addFlashAttribute("error", "This Video has already been added to your playlist");
            return "redirect:/playvideo?videoID=" + videoID;
        }


        Playlist newPlayListItem =  new Playlist(user, video);
        // add the video to the user playlist
        playlistImpl.addToPlayList(newPlayListItem);
        redirectAttributes.addFlashAttribute("success", "Video Added To PlayList");

        return"redirect:/playvideo?videoID=" + videoID;
    }
}
