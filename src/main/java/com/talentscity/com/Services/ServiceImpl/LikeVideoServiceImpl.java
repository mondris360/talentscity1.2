package com.talentscity.com.Services.ServiceImpl;

import com.talentscity.com.Entities.Like;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import com.talentscity.com.Repositories.LikeVideoRepository;
import com.talentscity.com.Services.LikeVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeVideoServiceImpl implements LikeVideoService {
    final
    LikeVideoRepository likeVideoRepository;
    @Autowired
    public LikeVideoServiceImpl(LikeVideoRepository likeVideoRepository) {
        this.likeVideoRepository = likeVideoRepository;
    }


    @Override
    // method to like a video
    public boolean likeVideo(User user, Video video) {
        Like like = new Like(user, video);

        // save like to db
        Like saveLike = likeVideoRepository.save(like);
        System.out.println("save like video" + saveLike);
        return true;
    }

    @Override
    // get a user like for a particular video
    public Like getUserVideoLike(User user, Video video) {

        return likeVideoRepository.findLikeByUserAndVideo(user, video);

    }

    @Override
    // method to delete user like entry for a particular video
    public void deleteLikeEntry(Like like) {

        likeVideoRepository.delete(like);
    }
}
