package com.talentscity.com.Services;

import com.talentscity.com.Entities.Like;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import org.springframework.stereotype.Service;

@Service
public interface LikeVideoService {
    boolean likeVideo(User user, Video Video);
    Like getUserVideoLike(User user, Video  video);
    void deleteLikeEntry(Like like);

}
