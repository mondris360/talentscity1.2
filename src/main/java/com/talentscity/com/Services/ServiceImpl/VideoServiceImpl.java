package com.talentscity.com.Services.ServiceImpl;

import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import com.talentscity.com.Repositories.VideoRepository;
import com.talentscity.com.Repositories.UserRepository;
import com.talentscity.com.Services.VideoService;
import com.talentscity.com.dto.UserDTO;
import com.talentscity.com.dto.VideoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    private VideoRepository videoRepository;
    private UserRepository userRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository, UserRepository userRepository) {
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Video uploadVideo(VideoRequestDTO newVideo, HttpServletRequest request) throws IOException {
        String mainDir = System.getProperty("user.dir");
        String subDir = "/src/main/resources/static/uploadedVideos";
        // get  the file extension from the original file name
        String fileExtension =  newVideo.getVideoFile().getOriginalFilename().split("\\.")[1];
        String storageLocation =  mainDir + subDir;
        // create new file name
        String newFileName = UUID.randomUUID().toString()+ "." + fileExtension;
        // storage location
        Path pathAndName = Paths.get(storageLocation, newFileName);
        // video src link
        String videoLink =  "/uploadedVideos/" + newFileName;
        newVideo.getVideoFile().transferTo(pathAndName);
        // get  the user object from the session
        HttpSession session =  request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        BigInteger userID =  userDTO.getUserID();
        // get user object from the database
        User user = userRepository.findUserByUserID(userID);
        // create a new video object
        Video video = new Video(newVideo.getTitle(), newVideo.getDescription(), videoLink, user);
        return videoRepository.save(video);

    }

    @Override
    // method to display all videos
    public List<Video> getAllUploadedVideos() {
        return videoRepository.findAll();

    }

    @Override
    public List<Video> getUserVideos(BigInteger userID) {
        return videoRepository.findAllByUser_UserID(userID);
    }

    @Override
    // method to  to retrieve a video from the db using the video ID
    public Video getVideoByID(Long videoID) {
        return videoRepository.getOne(videoID);
    }

}
