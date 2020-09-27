package com.talentscity.com.Services.ServiceImpl;

import com.talentscity.com.Entities.Playlist;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import com.talentscity.com.Repositories.PlaylistRepository;
import com.talentscity.com.Services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    private PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    // method to add a new video to user playlist
    public Playlist addToPlayList(Playlist newPlayListItem) {
        return playlistRepository.save(newPlayListItem);
    }

    @Override
    // get a video from the user playlist
    public Playlist getVideoFromUserPlaYList(User user, Video video) {
        return playlistRepository.findByUserAndVideo(user, video);
    }

    @Override
    // method to get all  the videos in the user playlist
    public List<Playlist> getUserPlayList(BigInteger userID) {
        return playlistRepository.getAllByUserUserIDOrderByDateAddedDesc(userID);
    }
}
