package com.talentscity.com.Repositories;

import com.talentscity.com.Entities.Playlist;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PlaylistRepository  extends JpaRepository<Playlist, BigInteger>{
    Playlist findByUserAndVideo(User user, Video video);
    List<Playlist> getAllByUserUserIDOrderByDateAddedDesc(BigInteger userID);
}
