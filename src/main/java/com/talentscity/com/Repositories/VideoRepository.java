package com.talentscity.com.Repositories;


import com.talentscity.com.Entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    Video save(Video newVideo);
    List<Video> findAllByUser_UserID(BigInteger userID);

}
