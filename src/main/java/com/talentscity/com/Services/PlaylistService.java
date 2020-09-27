package com.talentscity.com.Services;

import com.talentscity.com.Entities.Playlist;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface PlaylistService {
    Playlist addToPlayList(Playlist newPlayListItem);
    Playlist getVideoFromUserPlaYList (User user, Video vide);
    List<Playlist> getUserPlayList(BigInteger userID);
}
