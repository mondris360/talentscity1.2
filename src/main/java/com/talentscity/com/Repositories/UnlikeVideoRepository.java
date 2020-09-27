package com.talentscity.com.Repositories;

import com.talentscity.com.Entities.Dislike;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnlikeVideoRepository extends JpaRepository<Dislike, Long> {
    Dislike findDislikeByUserAndVideo(User user, Video video);
}
