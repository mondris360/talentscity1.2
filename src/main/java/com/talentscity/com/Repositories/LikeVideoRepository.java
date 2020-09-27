package com.talentscity.com.Repositories;

import com.talentscity.com.Entities.Like;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeVideoRepository extends JpaRepository<Like,  Long> {
    Like getLikeByLikeID(Long likeID);
    Like findLikeByUserAndVideo(User user, Video video);
//    Like deleteByLikeID(Long likeID);
}
